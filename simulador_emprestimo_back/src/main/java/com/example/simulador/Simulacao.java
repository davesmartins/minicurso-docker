
package com.example.simulador;

import jakarta.persistence.*;

@Entity
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private int meses;
    private double taxa;
    private double parcela;
    private double total;

    // Getters e Setters omitidos por brevidade
    public Long getId() { return id; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public int getMeses() { return meses; }
    public void setMeses(int meses) { this.meses = meses; }
    public double getTaxa() { return taxa; }
    public void setTaxa(double taxa) { this.taxa = taxa; }
    public double getParcela() { return parcela; }
    public void setParcela(double parcela) { this.parcela = parcela; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
