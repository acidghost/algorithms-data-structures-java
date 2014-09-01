package it.uniba.di.itps.asd.exams.Lab20090907;

/**
 * Created by acidghost on 01/09/14.
 */
public class ABEPF implements ABE {
    private NodoPF radice = null;

    @Override
    public boolean ABEVuoto() {
        return (radice == null);
    }

    @Override
    public Nodo radice() {
        if(radice == null) {
            throw new EccezioneAlberoVuoto();
        }
        return radice;
    }

    @Override
    public Nodo sin(Nodo v) {
        NodoPF nodo = (NodoPF) v;
        if(nodo.sin == null) {
            throw new EccezioneNodoInesistente();
        }
        return nodo.sin;
    }

    @Override
    public Nodo des(Nodo v) {
        NodoPF nodo = (NodoPF) v;
        if(nodo.des == null) {
            throw new EccezioneNodoInesistente();
        }
        return nodo.des;
    }

    @Override
    public void aggiungiRadice(String e) {
        if(radice != null) {
            throw new EccezioneNodoEsistente();
        }
        radice = new NodoPF(e);
    }

    @Override
    public void innestaSin(Nodo u, ABE albero, String e) {
        NodoPF nodo = (NodoPF) u;
        if(nodo.sin == null) {
            nodo.setSin((NodoPF) albero.radice(), e);
        } else {
            throw new EccezioneNodoEsistente();
        }
    }

    @Override
    public void innestaDes(Nodo u, ABE albero, String e) {
        NodoPF nodo = (NodoPF) u;
        if(nodo.des == null) {
            nodo.setDes((NodoPF) albero.radice(), e);
        } else {
            throw new EccezioneNodoEsistente();
        }
    }
}
