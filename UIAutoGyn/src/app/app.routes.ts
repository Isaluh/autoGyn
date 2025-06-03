import { Routes } from '@angular/router';
import { VeiculoCadAtComponent } from './Views/veiculoCadAt/veiculoCadAt.component';
import { VeiculoMarMoComponent } from './Views/veiculo-mar-mo/veiculo-mar-mo.component';

export const routes: Routes = [
    {path: '', component: VeiculoCadAtComponent},
    {path: 'veiculoCadAt', component: VeiculoCadAtComponent},
    {path: 'veiculoMarMo', component: VeiculoMarMoComponent},
    // {path: 'acessorios', component: },
    // {path: 'veiculos', component: },
    // {path: 'clientes', component: },
    // {path: 'cadastroSerPe', component: },
    // {path: 'cadastroColab', component: },
    // {path: 'gerencOs', component: },
    // {path: 'estoque', component: }
];
