package mx.edu.itson.practica5

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        agregarProductos()

        var listview: ListView = findViewById(R.id.listview) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador
    }

    fun agregarProductos() {
        menu.add(Product(name = "Quesadillas", R.drawable.quesadillas, description = "Rellenas con su carne favorita, servidas con ensalada.", price = 5.69))
        menu.add(Product(name = "Huaraches", R.drawable.huaraches, description = "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema.", price = 6.99))
        menu.add(Product(name = "Gringas", R.drawable.gringas, description = "Tortilla de harina con queso, carne al pastor y piña.", price = 7.99))
        menu.add(Product(name = "Sincronizadas", R.drawable.sincronizadas, description = "Tortilla de harina rellena de queso y jamón, servida con lechuga, crema y guacamole.", price = 6.49))
        menu.add(Product(name = "Sopes", R.drawable.sopes, description = "Tortilla gruesa frita cubierta con frijoles, carne, lechuga, queso fresco y crema.", price = 5.99))
        menu.add(Product(name = "Tostadas", R.drawable.tostadas, description = "Tortilla frita con frijoles, carne, lechuga, queso fresco, crema y jitomate.", price = 5.49))

        // Opciones de carnes
        menu.add(Product(name = "Asada", R.drawable.taco, description = "Carne de res", price = 4.99))
        menu.add(Product(name = "Pollo", R.drawable.taco, description = "Pollo", price = 4.99))
        menu.add(Product(name = "Carnitas", R.drawable.taco, description = "Cerdo desmenuzado", price = 4.99))
        menu.add(Product(name = "Chorizo", R.drawable.taco, description = "Salchicha mexicana", price = 4.99))
        menu.add(Product(name = "Suadero", R.drawable.taco, description = "Res deshebrada", price = 4.99))
        menu.add(Product(name = "Buche", R.drawable.taco, description = "Estómago de res", price = 4.99))
        menu.add(Product(name = "Pastor", R.drawable.taco, description = "Cerdo marinado", price = 4.99))
        menu.add(Product(name = "Cachete", R.drawable.taco, description = "Mejilla de res", price = 4.99))
        menu.add(Product(name = "Barbacoa", R.drawable.taco, description = "Carne al vapor", price = 4.99))
        menu.add(Product(name = "Lengua", R.drawable.taco, description = "Lengua de res", price = 5.99))
        menu.add(Product(name = "Tripa", R.drawable.taco, description = "Intestino de res", price = 5.99))
        menu.add(Product(name = "Chicharrón", R.drawable.taco, description = "Piel de cerdo", price = 4.99))
        menu.add(Product(name = "Cueritos", R.drawable.taco, description = "Piel de cerdo en vinagre", price = 4.99))

// Bebidas
        menu.add(Product(name = "Horchata", R.drawable.drinks, description = "Bebida tradicional mexicana", price = 2.99))
        menu.add(Product(name = "Tamarindo", R.drawable.drinks, description = "Bebida de tamarindo", price = 2.99))
        menu.add(Product(name = "Michelada", R.drawable.michelada, description = "Cerveza preparada con limón y salsas", price = 5.99))
        menu.add(Product(name = "Caguama", R.drawable.caguama, description = "Cerveza de gran tamaño", price = 6.99))
        menu.add(Product(name = "Jarritos", R.drawable.jarritos, description = "Refrescos de sabores", price = 2.50))

// Antojitos
        menu.add(Product(name = "Quesadillas", R.drawable.quesadillas, description = "Queso derretido en tortilla de maíz", price = 3.99))
        menu.add(Product(name = "Sopes", R.drawable.sopes, description = "Tortilla gruesa con frijoles y carne", price = 3.99))
        menu.add(Product(name = "Tostadas", R.drawable.tostadas, description = "Tortilla crujiente con carne y verduras", price = 3.99))
        menu.add(Product(name = "Huaraches", R.drawable.huaraches, description = "Tortilla alargada con carne y queso", price = 5.99))
        menu.add(Product(name = "Gringas", R.drawable.gringas, description = "Tortilla de harina con pastor y queso", price = 6.99))
        menu.add(Product(name = "Sincronizadas", R.drawable.sincronizadas, description = "Queso y jamón en tortilla de harina", price = 5.99))
        }

    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        @SuppressLint("MissingInflatedId")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val prod = productos[position]
            val inflador = LayoutInflater.from(contexto)
            val vista = inflador.inflate(R.layout.producto_view, null)

            val imagen = vista.findViewById<ImageView>(R.id.producto_img)
            val nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            val desc = vista.findViewById<TextView>(R.id.producto_desc)
            val precio = vista.findViewById<TextView>(R.id.producto_precio)

            imagen.setImageResource(prod.image)
            nombre.text = prod.name
            desc.text = prod.description
            precio.text = "$${prod.price}"

            return vista
        }
    }
}