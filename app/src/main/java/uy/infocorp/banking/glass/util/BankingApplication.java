package uy.infocorp.banking.glass.util;

import android.app.Application;
import android.content.Context;

/*
* El unico uso de esta instancia del contexto de la aplicacion es para obtener recursos sin pasarse
* instancias de Context para todos lados.
* NO usar para otras cosas como inflar un layout o mostrar un toast. (No va a funcionar)
* */

public class BankingApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
