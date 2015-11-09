package beans;
public class Cargamento{

	private String tipoCargamento;
	private float pesoCargamento;
	private boolean delicadoCargamento;

	public Cargamento(){

	}

	public Cargamento(String tipoCargamento,
		float pesoCargamento,boolean delicadoCargamento){

		this.tipoCargamento=tipoCargamento;
		this.pesoCargamento=pesoCargamento;
		this.delicadoCargamento=delicadoCargamento;

	}

	public void setTipoCargamento(String tipoCargamento){
		this.tipoCargamento=tipoCargamento;
	}

	public String getTipoCargamento(){
		return this.tipoCargamento;
	}

	public void setPesoCargamento(float pesoCargamento){
		this.pesoCargamento=pesoCargamento;
	}

	public float getPesoCargamento(){
		return this.pesoCargamento;
	}

	public void setDelicadoCargamento(
		boolean delicadoCargamento){

		this.delicadoCargamento=delicadoCargamento;

	}

	public boolean getDelicadoCargamento(){
		return this.delicadoCargamento;
	}

}