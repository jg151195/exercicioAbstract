package entities;

public class PessoaFisica extends Pessoa{
	
	private Double gastoSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}


	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}
	
	@Override
	public Double imposto() {
		Double imposto=0.0;
		if(getRendaAnual() < 20000.00) {
			imposto = getRendaAnual()*0.15 - getGastoSaude()*0.50;
		}
		else if (getRendaAnual()>20000.00) {
			imposto = getRendaAnual()*0.25 - getGastoSaude()*0.50;
		}	
		return imposto;
	}

}
