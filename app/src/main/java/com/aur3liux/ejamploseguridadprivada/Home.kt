package com.aur3liux.ejamploseguridadprivada

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun  Home(
    openVisita :()->Unit,
    openSalida : ()-> Unit,
    openListado: ()-> Unit,
    openHistorial: ()-> Unit,
    openConfiguracion: ()-> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            //Logotipo
           Image(
               modifier = Modifier.padding(1.dp, 50.dp, 1.dp, 10.dp),
               painter = painterResource(id = R.drawable.logotipo),
               contentDescription = "")

            //Boton visita
             ButonMenu("Registra visita"){
                 openVisita()
             }
            //Boton salida
            ButonMenu(titulo = "Registra salida"){
                openSalida()
            }
            //Boton listado
            ButonMenu(titulo = "Listado de visitantes"){
                openListado()
            }
            //Boton hotorial
            ButonMenu(titulo = "Hitorial"){
                openHistorial()
            }
            //Boton configuracion
            ButonMenu(titulo = "Configuracion"){
                openConfiguracion
            }

            //Boton de panico
           Row(
               modifier = Modifier
                   .align(Alignment.Start)
                   .padding(20.dp)
           ){
               Button(
                   modifier = Modifier
                       .width(250.dp)
                       .height(85.dp)
                       .clip(RoundedCornerShape(15.dp)),
                   colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                   onClick = {  }) {
                   Text("Botón de pánico",
                       color = Color.Yellow,
                       fontSize = 23.sp)
               }
           }
        }
    }
}

@Composable
fun ButonMenu(titulo: String, action: ()-> Unit) {
    Button(
        modifier = Modifier
            .width(300.dp)
            .height(80.dp)
            .padding(vertical = 5.dp)
            .clip(RoundedCornerShape(10.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0XFFCB9848)),
        onClick = { action() }) {
              Text(titulo,
                  color = androidx.compose.ui.graphics.Color.White,
              fontSize = 19.sp)
    }//Cierra Button
}