import { Routes } from '@angular/router';
import { VeiculoMarMoComponent } from './Views/veiculo-mar-mo/veiculo-mar-mo.component';
import { CadastroSerPeComponent } from './Views/cadastro-ser-pe/cadastro-ser-pe.component';
import { CadastroColabComponent } from './Views/cadastro-colab/cadastro-colab.component';
import { GerencOsComponent } from './Views/gerenc-os/gerenc-os.component';
import { ClientesComponent } from './Views/clientes/clientes.component';
import { VeiculosComponent } from './Views/veiculos/veiculos.component';
import { EstoqueComponent } from './Views/estoque/estoque.component';

export const routes: Routes = [
    {path: '', component: VeiculosComponent},
    {path: 'veiculoMarMo', component: VeiculoMarMoComponent},
    {path: 'veiculos', component: VeiculosComponent},
    {path: 'clientes', component: ClientesComponent},
    {path: 'cadastroSerPe', component: CadastroSerPeComponent},
    {path: 'cadastroColab', component: CadastroColabComponent},
    {path: 'gerencOs', component: GerencOsComponent},
    {path: 'estoque', component: EstoqueComponent}
];
