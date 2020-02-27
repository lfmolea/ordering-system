import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}
  platformBrowserDynamic().bootstrapModule(AppModule)
// logs `Can't resolve all parameters for App: (?)`
.catch(e => console.log('Bootstrap error', e));
