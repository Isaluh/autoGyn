package com.bamboobyte.APIAutoGyn.Validacoes.Observer;

import com.bamboobyte.APIAutoGyn.Entities.OS;

public interface OSSujeito {

    void adicionarObserver(OSObserver observer);

    void removerObserver(OSObserver observer);

    void notificarObservers(OS os);
}
