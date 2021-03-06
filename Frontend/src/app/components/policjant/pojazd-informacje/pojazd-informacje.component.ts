import {Component, OnInit, Output, EventEmitter, Input, OnChanges, SimpleChanges} from '@angular/core';
import * as $ from 'jquery';
import {Samochod} from "../../../_mocks/samochod";


@Component({
  selector: 'pojazd-info',
  templateUrl: 'pojazd-informacje.component.html'
})
export class PojazdInfo implements OnInit,OnChanges {
  @Input() TableData: Array<any>;
  @Output() notify = new EventEmitter();

  public rows: Array<any> = [];
  public columns: Array<any> = [
    {title: 'Rodzaj', name: 'rodzaj_pojazdu'},
    {title: 'Marka', name: 'marka'},
    {title: 'Model', name: 'model'},
    {title: 'Rejestracja', name: 'd_nr_rejestracyjny'},
    {title: 'VIN', name: 'nr_VIN'},
    {title: 'Rok', name: 'rok_produkcji'},
    {title: 'Masa', name: 'masa'},
    {title: 'Pojemność', name: 'p_silnika'},
    {title: 'Moc', name: 'm_silnika'},
    {title: 'Rodzaj paliwa', name: 'r_paliwa'}
  ];
  public page: number = 1;
  public itemsPerPage: number = 6;
  public maxSize: number = 5;
  public numPages: number = 1;
  public length: number = 0;

  public config: any = {
    paging: true,
    sorting: {columns: this.columns},
    filtering: {filterString: ''},
    className: ['table-striped', 'table-bordered']
  };

  private contentData: Array<any> = [];

  public constructor() {
    this.length = this.contentData.length;
  }

  public ngOnInit(): void {
    $('pojazd-info tbody').addClass('pointer');
    $('pojazd-info').hide();
    this.onChangeTable(this.config);
  }

  ngOnChanges(changes: SimpleChanges): void {
    $('tbody > tr').each(function () {
      if ($(this).index() % 2 == 0) {
        $(this).css('background-color', 'rgba(0, 0, 0, 0.05)');
      } else {
        $(this).css('background-color', 'transparent');
      }
    });
    if (this.TableData.length > 0) {
      for (let i = 0; i < this.TableData.length; i++) {
        this.contentData.push({
          'rodzaj_pojazdu': this.TableData[i].rodzaj_pojazdu,
          'marka': this.TableData[i].marka,
          'model': this.TableData[i].model,
          'd_nr_rejestracyjny': this.TableData[i].d_nr_rejestracyjny,
          'nr_VIN': this.TableData[i].nr_VIN,
          'rok_produkcji': this.TableData[i].rok_produkcji,
          'masa': this.TableData[i].masa + 'kg',
          'p_silnika': this.TableData[i].p_silnika + 'l',
          'm_silnika': this.TableData[i].m_silnika + 'kW',
          'r_paliwa': this.TableData[i].r_paliwa
        })
      }
      this.onChangeTable(this.config);
      $('pojazd-info').fadeIn('slow');
    }
    else {
      this.contentData = [];
      $('pojazd-info').hide();
    }
  }


  public changePage(page: any, data: Array<any> = this.contentData): Array<any> {
    let start = (page.page - 1) * page.itemsPerPage;
    let end = page.itemsPerPage > -1 ? (start + page.itemsPerPage) : data.length;
    return data.slice(start, end);
  }

  public changeSort(data: any, config: any): any {
    if (!config.sorting) {
      return data;
    }

    let columns = this.config.sorting.columns || [];
    let columnName: string = void 0;
    let sort: string = void 0;

    for (let i = 0; i < columns.length; i++) {
      if (columns[i].sort !== '' && columns[i].sort !== false) {
        columnName = columns[i].name;
        sort = columns[i].sort;
      }
    }

    if (!columnName) {
      return data;
    }

    // simple sorting
    return data.sort((previous: any, current: any) => {
      if (previous[columnName] > current[columnName]) {
        return sort === 'desc' ? -1 : 1;
      } else if (previous[columnName] < current[columnName]) {
        return sort === 'asc' ? -1 : 1;
      }
      return 0;
    });
  }

  public changeFilter(data: any, config: any): any {
    let filteredData: Array<any> = data;
    this.columns.forEach((column: any) => {
      if (column.filtering) {
        filteredData = filteredData.filter((item: any) => {
          return item[column.name].match(column.filtering.filterString);
        });
      }
    });

    if (!config.filtering) {
      return filteredData;
    }

    if (config.filtering.columnName) {
      return filteredData.filter((item: any) =>
        item[config.filtering.columnName].match(this.config.filtering.filterString));
    }

    let tempArray: Array<any> = [];
    filteredData.forEach((item: any) => {
      let flag = false;
      this.columns.forEach((column: any) => {
        if (item[column.name].toString().match(this.config.filtering.filterString)) {
          flag = true;
        }
      });
      if (flag) {
        tempArray.push(item);
      }
    });
    filteredData = tempArray;

    return filteredData;
  }

  public onChangeTable(config: any, page: any = {page: this.page, itemsPerPage: this.itemsPerPage}): any {
    if (config.filtering) {
      Object.assign(this.config.filtering, config.filtering);
    }

    if (config.sorting) {
      Object.assign(this.config.sorting, config.sorting);
    }

    let filteredData = this.changeFilter(this.contentData, this.config);
    let sortedData = this.changeSort(filteredData, this.config);
    this.rows = page && config.paging ? this.changePage(page, sortedData) : sortedData;
    this.length = sortedData.length;
  }

  public onCellClick(data: any): any {
    let samochod = new Samochod(data.row.rodzaj_pojazdu, data.row.marka, data.row.model,
      data.row.rok_produkcji, data.row.nr_VIN, data.row.masa, data.row.d_nr_rejestracyjny, data.row.p_silnika, data.row.m_silnika, data.row.zasilanie)
    this.notify.emit(samochod);
    $('pojazd-info tbody > tr').click(function () {
      $(this).css('background-color', '#61f661');
      $(this).siblings().each(function () {
        if ($(this).index() % 2 == 0) {
          $(this).css('background-color', 'rgba(0, 0, 0, 0.05)');
        } else {
          $(this).css('background-color', 'transparent');
        }
      });
    });
  }
}
