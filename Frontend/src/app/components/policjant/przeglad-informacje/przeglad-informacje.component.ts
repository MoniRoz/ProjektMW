import {Component, OnInit, Input, SimpleChanges, OnChanges} from '@angular/core';
import * as $ from 'jquery';


@Component({
  selector: 'przeglad-info',
  templateUrl: 'przeglad-informacje.component.html'
})
export class PrzegladInfo implements OnInit,OnChanges {
  @Input() TableData: Array<any>;

  public rows: Array<any> = [];
  public columns: Array<any> = [
    {title: 'Data wystawienia', name: 'd_wystawienia', sort: 'desc'},
    {title: 'Data ważności', name: 'd_waznosci'},
    {title: 'Wystawiający', name: 'wystawiajacy'}

  ];
  public page: number = 1;
  public itemsPerPage: number = 2;
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
    $('przeglad-info').hide();
    this.onChangeTable(this.config);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.TableData.length > 0) {
      this.contentData = this.TableData;
      this.onChangeTable(this.config);
      $('przeglad-info').fadeIn('slow');
    }
    else {
      this.contentData = [];
      $('przeglad-info').hide();
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
    console.log(data);
  }
}
