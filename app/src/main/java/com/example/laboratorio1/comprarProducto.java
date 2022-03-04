package com.example.laboratorio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class comprarProducto extends AppCompatActivity {

    //Creacion de objeto para regresar a la MainActivity
    Button btnVolver;

    //Creando objetos
    TextView txvProducto, txvEspecificaciones, txvPrecio, txvCantidad, txvtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_producto);

        //Obtenemos el valor de los objetos y los asignamos a las variables
        txvProducto = (TextView)findViewById(R.id.txvProductoC);
        txvEspecificaciones = (TextView)findViewById(R.id.txvEspecificacionesC);
        txvPrecio = (TextView)findViewById(R.id.txvPrecioC);
        txvCantidad = (TextView)findViewById(R.id.txvCantidadC);
        txvtotal = (TextView)findViewById(R.id.txvTotalC);

        //Permite el paso de datos entre las activities
        Bundle bundle = getIntent().getExtras();

        //Asignamos el valor a las variables
        String producto = bundle.getString("producto");
        txvProducto.setText(producto);
        String especificaciones = bundle.getString("especificaciones");
        txvEspecificaciones.setText(especificaciones);
        String precio = bundle.getString("precio");
        txvPrecio.setText(precio);
        String cantidad = bundle.getString("cantidad");
        txvCantidad.setText(cantidad);
        String total = bundle.getString("total");
        txvtotal.setText(total);


        //codigo regresar primer activity
        //Instanciamos el objeto
        btnVolver = findViewById(R.id.btnVolver);

        ///Creamos la instancia para regresar a la primer activity
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(comprarProducto.this, MainActivity.class);
                startActivity(regresar);
            }
        });

    }
}