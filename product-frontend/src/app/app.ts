import { Component } from '@angular/core';
import { ProductoListComponent } from './components/producto-list/producto-list';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ProductoListComponent],
  templateUrl: './app.html',
})
export class AppComponent {
  title = 'product-frontend';
}
