package Pousada;

public class Pousada {
    private int qtdQuartos;
    private String nome;
    private String email;
    private boolean ocupado;
 
 // Construtores Simples 
 public int getQtdQuartos() {
     return qtdQuartos = 10;
 }
 public void setQtdQuartos(int qtdQuartos) {
     this.qtdQuartos = qtdQuartos;
 }

 public Pousada(){
    this.email = "";
    this.nome = "";
 }
public void CheckIn(String nome, String email){
    this.email = email;
    this.nome = nome;
    this.ocupado = true;
}

public void CheckOut(){
    this.email = "";
    this.nome = "";
    this.ocupado = false;
}

public void ListarQuartos(){

}
 

//GETTERS E SETTERS
 public String getNome() {
     return nome;
 }
 public void setNome(String nome) {
     this.nome = nome;
 }
 public String getEmail() {
     return email;
 }
 public void setEmail(String email) {
     this.email = email;
 }
 public boolean isOcupado() {
     return ocupado;
 }
 public void setOcupado(boolean ocupado) {
     this.ocupado = ocupado;
 }

}