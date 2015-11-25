package beans;
public class Cargamento{

	private String tipoCargamento;
	private float pesoCargamento;
	private boolean delicadoCargamento;
	private int cargamentoID,fleteID;

	public Cargamento(){

	}

	public Cargamento(String tipoCargamento,
		float pesoCargamento,boolean delicadoCargamento){
		this.tipoCargamento=tipoCargamento;
		this.pesoCargamento=pesoCargamento;
		this.delicadoCargamento=delicadoCargamento;
	}

	public Cargamento(String tipoCargamento,
		float pesoCargamento,boolean delicadoCargamento,int cargamentoID){

		this.cargamentoID=cargamentoID;
		this.tipoCargamento=tipoCargamento;
		this.pesoCargamento=pesoCargamento;
		this.delicadoCargamento=delicadoCargamento;

	}

	public Cargamento(int fleteID,String tipoCargamento,
		float pesoCargamento,boolean delicadoCargamento){

		this.fleteID=fleteID;
		this.tipoCargamento=tipoCargamento;
		this.pesoCargamento=pesoCargamento;
		this.delicadoCargamento=delicadoCargamento;

	}

	public Cargamento(int fleteID,String tipoCargamento,
		float pesoCargamento,boolean delicadoCargamento,int cargamentoID){
		this.fleteID=fleteID;
		this.cargamentoID=cargamentoID;
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

	public void setFleteID(int fleteID){
		this.fleteID=fleteID;
	}

	public int getFleteID(){
		return this.fleteID;
	}

	public void setCargamentoID(int cargamentoID){
		this.cargamentoID=cargamentoID;
	}

	public int getCargamentoID(){
		return cargamentoID;
	}

}