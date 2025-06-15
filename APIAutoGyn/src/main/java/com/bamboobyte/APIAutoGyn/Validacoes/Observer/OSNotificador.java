package com.bamboobyte.APIAutoGyn.Validacoes.Observer;

import com.bamboobyte.APIAutoGyn.Entities.OS;

public class OSNotificador implements OSObserver {

    @Override
    public void atualizar(OS os) {
        System.out.println("🔔 Notificação: OS " + os.getId() + " mudou para etapa " + os.getEtapa());
    }
}