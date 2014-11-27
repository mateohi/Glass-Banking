package uy.infocorp.banking.glass.util.offline;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/*
* El objetivo de esta clase es brindar un contexto para poder obtener recursos sin necesidad
* de pasar un objeto Context por parametro para obtener el recurso
*/

public class OfflineResourceContext2 extends Activity {

    private static Context context;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        context = this;
    }

    public static Context instance() {
        return context;
    }
}
