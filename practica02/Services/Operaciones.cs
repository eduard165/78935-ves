using System;
using WSDL.mensajes;

namespace WSDL.operaciones {
    public class Operaciones : Mensajes
    {
        List<string> nombres = new List<string>();
        public string mostrar(int id)
        {
            if(id < 0 || id >= nombres.Count()) {
                return "Valor no valido";
            }
            return nombres[id];
        }
        public string Saludar(string nombre)
        {
            nombres.Add(nombre);
            string msj = "hola " + nombre;
            
            return msj;
        }
    }
}