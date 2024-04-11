class Arbol {
Nodo raiz;
private int posicion;
private StringBuilder ordenProvisional;

public Arbol() {
    this.raiz = null;
}

public int NodosCompletos(Nodo n){
    if(n == null){
        return 0;
    } else {
        if (n.getIzquierda() != null && n.getDerecha() != null) 
            return NodosCompletos(n.getIzquierda()) + NodosCompletos(n.getDerecha()) + 1;
            return NodosCompletos(n.getDerecha()) + NodosCompletos(n.getIzquierda());  
    }
}

public boolean existe(String busqueda) {
return existe(this.raiz, busqueda);
}

private boolean existe(Nodo n, String busqueda) {
if (n == null) {
return false;
}
if (n.getDato().equals(busqueda)) {
return true;
} else if (busqueda.compareTo(n.getDato()) < 0) {
    this.posicion =+ 1;
return existe(n.getIzquierda(), busqueda);
} else {
    this.posicion =+ 1;
return existe(n.getDerecha(), busqueda);   
}
}

public void insertar(String dato) {
if (this.raiz == null) {
this.raiz = new Nodo(dato);
} else {
this.insertar(this.raiz, dato);
}
}

private void insertar(Nodo padre, String dato) {
if (dato.compareTo(padre.getDato()) > 0) {
if (padre.getDerecha() == null) {
padre.setDerecha(new Nodo(dato));
} else {
this.insertar(padre.getDerecha(), dato);
}

} else {
if (padre.getIzquierda() == null) {
padre.setIzquierda(new Nodo(dato));
} else {
this.insertar(padre.getIzquierda(), dato);
}
}
}

private void preorden(Nodo n) {
if (n != null) {
ordenProvisional.append(n.dato).append("\n");
preorden(n.getIzquierda());
preorden(n.getDerecha());
}
}

private void inorden(Nodo n) {
if (n != null) {
inorden(n.getIzquierda());
ordenProvisional.append(n.dato).append("\n");
inorden(n.getDerecha());
}
}

private void postorden(Nodo n) {
if (n != null) {
postorden(n.getIzquierda());
postorden(n.getDerecha());
ordenProvisional.append(n.dato).append("\n");
}
}

public StringBuilder preorden() {
    ordenProvisional = new StringBuilder();
    this.preorden(this.raiz);
    return ordenProvisional;
}

public StringBuilder inorden() {
    ordenProvisional = new StringBuilder();
    this.inorden(this.raiz);
    return ordenProvisional;
}

public StringBuilder postorden() {
    ordenProvisional = new StringBuilder();
    this.postorden(this.raiz);
    return ordenProvisional;
}

public void vaciar() {
    raiz = null; // Elimina la raíz del árbol, lo que eventualmente eliminará todos los nodos
}
}
