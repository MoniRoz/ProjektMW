import { MwProjectAppPage } from './app.po';

describe('mw-project-app App', function() {
  let page: MwProjectAppPage;

  beforeEach(() => {
    page = new MwProjectAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
