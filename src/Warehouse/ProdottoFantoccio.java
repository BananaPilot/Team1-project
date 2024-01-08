package Warehouse;

public class ProdottoFantoccio {
    public int id = 0;
    private static int staticId =0;
    public int idTipo = 0;
    private static int staticIdTipo = 0;
    public String nome;
    private String brand;
    private double prezzo;
    public int posizione;

    public ProdottoFantoccio(String nome, String brand, double prezzo){
        this.staticId++;
        this.id = staticId;
        this.staticIdTipo++;
        this.idTipo = staticIdTipo;
        this.nome = nome;
        this.brand = brand;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Warehouse.ProdottoFantoccio{" +
                "id=" + id +
                ", idTipo=" + idTipo +
                ", nome='" + nome + '\'' +
                ", brand='" + brand + '\'' +
                ", prezzo=" + prezzo +
                ", posizione=" + posizione +
                '}';
    }
}
