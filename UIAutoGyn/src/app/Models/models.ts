export interface Veiculos{
    id: number | null,
    placa: string;
    idCliente: number | null;
    anoFabricacao: number | null;
    anoModelo: number | null;
    idModelo: number | null;
    km: number | null;
}

export interface Marcas{
    id: number | null,
    nome: string
}

export interface Modelos{
    id: number | null,
    marca: Marcas,
    nome: string
}

export interface MarcaComModelos {
  id: number;
  nomeMarca: string;
  nomeModelos: string[];
}

export interface Servicos{
    id: number | null,
    descricao: string
    valor: number | null,
    formatado: string

}

export interface Pecas{
    id: number | null,
    codigo: number | null,
    descricao: string
    sku: number | null,
    quantidadeEstoque: number | null,
    valorUnitario: number | null
}

export interface Colaboradores{
    id: number | null,
    nome: string,
    cpf: number | null
}

interface ServicoColaborador {
    servico: Servicos | null;
    colaborador: Colaboradores | null;
}

export interface OrdensServico {
    id: number | null;
    veiculo: Veiculos;
    servicosColaboradores: ServicoColaborador[];
    peca: Pecas[];
    orcamento: number | null;
}

export interface Clientes {
  nome: string;
  email: string;
  logradouro: string;
  complemento: string;
  numero: string;
  cep: string;
  cidade: string;
  uf: string;
  ddd: number | null;
  telefone: number | null;
  ddd2: number | null;
  telefone2: number | null;
  cnpj: string;
  inscricaoEstadual: string;
  nomeContato: string;
  cpf: string;
  isPJ: boolean;
  isPF: boolean;
}
