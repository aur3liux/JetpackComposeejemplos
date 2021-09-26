package com.aur3liux.ejamploseguridadprivada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aur3liux.ejamploseguridadprivada.ui.theme.EjamploSeguridadPrivadaTheme

sealed class Screen(var ruta: String){
    object HOME: Screen("Home")
    object VISITA: Screen("Visita")
    object SALIDA: Screen("Salida")
    object LISTADO: Screen("Listado")
    object HISTORIAL: Screen("Historial")
    object CONFIGURACION: Screen("Configuracion")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            EjamploSeguridadPrivadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HOME.ruta){
                        //Home
                        composable(Screen.HOME.ruta){
                            Home(
                                openVisita = {
                                     navController.navigate(Screen.VISITA.ruta){
                                         popUpTo(Screen.HOME.ruta)
                                     }
                                },
                                openSalida = {
                                    navController.navigate(Screen.SALIDA.ruta){
                                        popUpTo(Screen.HOME.ruta)
                                    }
                                },
                                openListado = {
                                    navController.navigate(Screen.LISTADO.ruta){
                                        popUpTo(Screen.HOME.ruta)
                                    }
                                },
                                openHistorial = {
                                    navController.navigate(Screen.HISTORIAL.ruta){
                                        popUpTo(Screen.HOME.ruta)
                                    }
                                },
                                openConfiguracion = {
                                    navController.navigate(Screen.CONFIGURACION.ruta){
                                        popUpTo(Screen.HOME.ruta)
                                    }
                                }
                            )
                        }
                        //Visita
                        composable(Screen.VISITA.ruta){
                            Visita()
                        }
                        //Salida
                        composable(Screen.SALIDA.ruta){
                            Salida()
                        }
                        //Listado
                        composable(Screen.LISTADO.ruta){
                            Listado()
                        }
                        //Historial
                        composable(Screen.HISTORIAL.ruta){
                            Historial()
                        }
                        //Configuracion
                    }
                }
            }
        }
    }
}
