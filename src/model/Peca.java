package model;

import java.util.Date;

public class Peca {

	private int codPeca;
	private String nome;
	private int nfiscal;
	private double valor;
	private int qtde;
	private String cnpjForn;
	private int id_os;
	private Date dtNota;

	public int getCodPeca() {
		return codPeca;
	}

	public void setCodPeca(int codPeca) {
		this.codPeca = codPeca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNfiscal() {
		return nfiscal;
	}

	public void setNfiscal(int nfiscal) {
		this.nfiscal = nfiscal;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public String getCnpjForn() {
		return cnpjForn;
	}

	public void setCnpjForn(String cnpjForn) {
		this.cnpjForn = cnpjForn;
	}

	public int getId_os() {
		return id_os;
	}

	public void setId_os(int id_os) {
		this.id_os = id_os;
	}

	public Date getDtNota() {
		return dtNota;
	}

	public void setDtNota(Date dtNota) {
		this.dtNota = dtNota;
	}

}
