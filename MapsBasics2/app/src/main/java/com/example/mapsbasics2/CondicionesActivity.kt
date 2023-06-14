package com.example.mapsbasics2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class CondicionesActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condiciones)

        val button: Button = findViewById(R.id.Aceptar)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.Rechazar)
        button2.setOnClickListener {
            finish() // Cierra la actividad actual y sale de la aplicación
        }

        val textView = findViewById<TextView>(R.id.textView)

        textView.text = "Bienvenido al Proyecto de Cementerio con Realidad Aumentada. A continuación, se presentan las condiciones de uso que rigen nuestra plataforma y garantizan la seguridad de la información del difunto:\n" +
                "\n" +


                "a. La información personal y los datos del difunto almacenados en nuestra plataforma serán tratados de manera confidencial y protegidos de acuerdo con las leyes de privacidad aplicables.\n" +
                "b. Nos comprometemos a tomar medidas técnicas y organizativas adecuadas para salvaguardar la información y prevenir cualquier acceso no autorizado o divulgación.\n" +
                "\n" +
                "Recopilación y uso de información:\n" +
                "a. La plataforma recopilará información relevante sobre el difunto, como nombre, fecha de nacimiento, fecha de fallecimiento, fotografías y cualquier otro detalle proporcionado por los familiares o responsables.\n" +
                "b. Esta información se utilizará exclusivamente con fines relacionados con la gestión y visualización de la realidad aumentada en el contexto del cementerio virtual.\n" +
                "\n" +
                "Acceso y visualización de la realidad aumentada:\n" +
                "a. La realidad aumentada permitirá a los usuarios experimentar contenido digital relacionado con el difunto, como imágenes, videos o mensajes conmemorativos.\n" +
                "b. El acceso a la realidad aumentada estará sujeto a la autorización y permisos adecuados. Solo los usuarios autorizados podrán acceder a la información y contenido asociado a un difunto en particular.\n" +
                "\n" +
                "Responsabilidad del usuario:\n" +
                "a. Los usuarios deben garantizar que tienen los derechos legales para proporcionar la información del difunto y otorgar los permisos necesarios para su uso en el proyecto.\n" +
                "b. Los usuarios se comprometen a no utilizar la plataforma para difamar, acosar, violar los derechos de privacidad o cualquier otro comportamiento inapropiado.\n" +
                "\n" +
                "Propiedad intelectual:\n" +
                "a. Los derechos de propiedad intelectual de los contenidos generados por los usuarios, como fotografías, videos o mensajes, seguirán siendo propiedad del usuario respectivo.\n" +
                "b. Al utilizar nuestra plataforma, los usuarios otorgan una licencia no exclusiva para el uso, reproducción y distribución de los contenidos generados por ellos en el contexto del proyecto.\n" +
                "\n" +
                "Modificaciones y terminación:\n" +
                "a. Nos reservamos el derecho de realizar modificaciones en las condiciones de uso en cualquier momento, y dichos cambios entrarán en vigencia después de su publicación.\n" +
                "b. Nos reservamos el derecho de terminar o suspender el acceso a la plataforma en caso de incumplimiento de las condiciones de uso o si la información proporcionada resulta falsa o engañosa.\n" +
                "\n" +
                "Al utilizar nuestra plataforma de Cementerio con Realidad Aumentada, aceptas cumplir con estas condiciones de uso. Te recomendamos revisar periódicamente las condiciones, ya que pueden actualizarse. Si tienes alguna pregunta o inquietud sobre nuestra política de seguridad y privacidad, no dudes en contactarnos.\n" +
                "\n" +
                "Gracias por ser parte de nuestro proyecto y ayudarnos a mantener la seguridad y el respeto hacia los difuntos y sus familias."









    }
}