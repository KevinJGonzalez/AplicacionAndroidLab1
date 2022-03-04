package com.example.laboratorio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class productoelegido extends AppCompatActivity {

    //Objetos que posee la activity
    TextView txvProducto, txvEspecificaciones, txvPrecio;
    EditText edtCantidad;
    Button btnComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productoelegido);

        TextView categoria = findViewById(R.id.txvproducto);
        categoria.setText(getIntent().getStringExtra("categoria"));

        ImageView imagen = findViewById(R.id.imvImagen);
        imagen.setImageResource(getIntent().getIntExtra("imagen", 0));

        TextView precio = findViewById(R.id.txvPrecio);
        precio.setText(getIntent().getStringExtra("precio"));

        TextView especificaciones = findViewById(R.id.txvEspecificaciones);
        especificaciones.setText(getIntent().getStringExtra("especificaciones"));


        //Obtenemos el valor de los objetos y los asignamos a las variables
        txvProducto = (TextView) findViewById(R.id.txvproducto);
        txvEspecificaciones = (TextView) findViewById(R.id.txvEspecificaciones);
        txvPrecio = (TextView) findViewById(R.id.txvPrecio);
        edtCantidad = (EditText)findViewById(R.id.edtCantidad);
        btnComprar = (Button)findViewById(R.id.btnComprar);


        //Creamos la instancia a la activity Comprar Producto
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Indicar que se debe de llenar el campo de camtidad
                if (edtCantidad.getText().toString().isEmpty()){
                    edtCantidad.setError("Ingresar Cantidad");
                    return;
                }


                //Pasando valores de los campos a las variables para realizar el calculo
                int cantidad, precio, total;
                cantidad = Integer.parseInt(edtCantidad.getText().toString());
                precio = Integer.parseInt(txvPrecio.getText().toString());
                total = cantidad * precio;

                //Conexion a la activity Comprar Producto
                Intent comprar = new Intent(productoelegido.this, comprarProducto.class);

                //Enviando la informacion a la Activity Comprar Producto
                comprar.putExtra("producto", txvProducto.getText().toString());
                comprar.putExtra("especificaciones", txvEspecificaciones.getText().toString());
                comprar.putExtra("precio", "$ " + txvPrecio.getText().toString());
                comprar.putExtra("cantidad", edtCantidad.getText().toString());
                comprar.putExtra("total", "$ " + total);
                startActivity(comprar);

            }
        });

    }

}