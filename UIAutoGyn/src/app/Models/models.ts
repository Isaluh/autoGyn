export interface Veiculos{
    id: number | null,
    proprietario: {},
    placa: string,
    anoFabricacao : number | null,
    anoModelo : number | null,
    marca: {},
    modelo: {},
    kms: number | null,
    numChassi: number | null,
    numPatrimonio: number | null,
    acessorios: []
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


export interface Acessorios{
    id: number | null,
    descricao: string
}

export interface Servicos{
    id: number | null,
    servico: string
    valor: number | null
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

export interface OrdensServico{
    id: number | null,
    veiculo: {},
    servico: Servicos[],
    peca: Pecas[]
    orcamento: number | null
}