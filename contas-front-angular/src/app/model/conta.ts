interface Conta {
  id: number;
  valor: number;
  vencimento: Date;
  pagamento: Date;
  credor: Credor;
}