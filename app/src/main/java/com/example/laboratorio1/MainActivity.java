package com.example.laboratorio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    //Se crean los objetos
    private ListView mlsvProductos;
    private List<Modelo> mList = new ArrayList<>();
    Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciando al objeto listview
        mlsvProductos = findViewById(R.id.lsvProductos);
        //Especifica a que elemento se le da clic
        mlsvProductos.setOnItemClickListener(this);

        //Asignar los elementos del listView
        //Laptops
        mList.add(new Modelo(
                "Laptops",
                "Las computadoras portátiles equipadas con Intel ofrecen un rendimiento destacado" +
                        " y una portabilidad práctica para todo.",
                R.drawable.laptop));

        //Microprocesadores
        mList.add(new Modelo(
                "Microprocesadores",
                "Los CPUs de mayor desempeño de Intel para portátiles y PCs de desktop." +
                " Potencia, velocidad y calidad al alcance de su mano.",
                R.drawable.microprocesador));

        //Tarjetas Gráficas
        mList.add(new Modelo(
                "Tarjetas Gráficas",
                "Trabajo y juego al mismo tiempo en alta resolución con lo ultimo en tarjetas" +
                " gráficas en el mercado.",
                R.drawable.tarjetagrafica));

        //Memorias Ram
        mList.add(new Modelo(
                "Memorias RAM",
                "Acelere su sistema y obtenga una velocidad y capacidad de respuesta" +
                " asombrosas sin comprometer su almacenamiento.",
                R.drawable.memoriaram));

        //Preparacion del adapter
        mAdapter = new Adapter(MainActivity.this,R.layout.productos,mList);
        mlsvProductos.setAdapter(mAdapter);

    }

    String precio, especificaciones, posicion;


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        //elemento al que se ha dado clic
        if (position == 0){
            posicion = "Producto seleccionado: Laptop";
        } else if (position == 1){
            posicion = "Producto seleccionado: Microprocesador";
        } else if (position == 2){
            posicion = "Producto seleccionado: Tarjeta Gráfica";
        } else if (position == 3){
            posicion = "Producto seleccionado: Memoria RAM";
        }

        Toast.makeText(this, posicion, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, productoelegido.class);

        intent.putExtra("categoria", mAdapter.getItem(position).getCategoria());
        intent.putExtra("imagen", mAdapter.getItem(position).getIcono());

        if(position == 0){
            precio = "900";
            especificaciones = "Equipada con una pantalla de resolución Full HD con tecnología Acer Color Intelligence" +
                    " para presentar imágenes nítidas y reales. Además, el software de bloqueo de luz azul Blue " +
                    "Light Shield ayuda a proteger la visión del usuario cuando tiene que trabajar durante el día," +
                    " Posee 8GB y disco duro 512 SSD con un procesador Intel® Core™ i7-1065G.";
        } else if (position == 1){
            precio = "500";
            especificaciones = "Rendimiento Cantidad de núcleos 8 Cantidad de subprocesos 16 Frecuencia básica del" +
                    " procesador 2,90 GHz Frecuencia turbo máxima 4,80 GHz Caché 16 MB Intel® Smart Cache " +
                    "Velocidad del bus 8 GT/s Frecuencia de la Tecnología Intel® Turbo Boost Max 3.0 ‡ 4,80 GHz " +
                    "TDP 65 W, Con un Tamaño de memoria máximo de 128 GB.";
        } else if (position == 2){
            precio = "1500";
            especificaciones = "Real Boost Reloj: 1882 MHz; Detalle de memoria: 12288 MB GDDR6. Seguimiento de " +
                    "rayos en tiempo real en juegos para gráficos de vanguardia, hiperrealistas. Los ventiladores" +
                    " de refrigeración dobles ofrecen un mayor rendimiento de refrigeración y ruido acústico " +
                    "mucho más silencioso. Placa trasera totalmente metálica.";
        } else if (position == 3){
            precio = "125";
            especificaciones = "Capacidad 16 GB (2 x 8 GB). Tipo SDRAM DDR4 de 288 pines. Velocidad DDR4 3600 " +
                    "(PC4 28800). Características Ideal para jugadores y entusiastas del rendimiento. Personalice" +
                    " la combinación de colores de su equipo con 16 LED RGB en 8 zonas en cada módulo.Recomendar " +
                    "uso Memoria de alto rendimiento o para juegos a Color LED RGB.";
        }

        intent.putExtra("precio", precio);
        intent.putExtra("especificaciones", especificaciones);

        startActivity(intent);
    }


}