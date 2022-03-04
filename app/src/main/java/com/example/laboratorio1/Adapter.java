package com.example.laboratorio1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

//Clase con herencia a la clase Modelo
public class Adapter extends ArrayAdapter<Modelo> {

    //Crear la lista para el modelo
    private List<Modelo> mList;
    //Especificar de donde vamos a asignar los datos
    private Context mContext;
    //Asigar recursos de la activity
    private int resourceLayout;

    //Constructor de la clase Adapter
    public Adapter(@NonNull Context context, int resource, List<Modelo> objects) {
        super(context, resource, objects);
        this.mList = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    } //Fin de constructor


    //Codigo que permite buscar las vistas que se pondran en cada elemento del ListView
    @NonNull
    @Override
    //Metodo para mostrar cada <view de las imagenes y texto
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //<crear un view
        View view = convertView;

        //Verificar si el null el View
        if(view == null)
            view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        //Posicion de los elementos del view
        Modelo modelo = mList.get(position);

        //Especificar que encuentre los elementos del layout "productos.xml"
        ImageView imagen = view.findViewById(R.id.imvProducto);
        imagen.setImageResource(modelo.getIcono());

        TextView categoria = view.findViewById(R.id.txvCategoria);
        categoria.setText(modelo.getCategoria());

        TextView descripcion = view.findViewById(R.id.txvDescripcion);
        descripcion.setText(modelo.getDescripcion());

        //Retornando el conjunto de elementos view
        return view;

    }


}
