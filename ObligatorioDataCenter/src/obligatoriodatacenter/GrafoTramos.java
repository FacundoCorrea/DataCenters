
package obligatoriodatacenter;

import obligatoriodatacenter.Punto;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GrafoTramos {
    private int MAX = 10005; 

    public GrafoTramos() {
    }
    
    public void setMAX(int MAX) {
        this.MAX = MAX;
    }
    private final int INF = 1 << 30;  //definimos un valor grande que represente la distancia infinita inicial, basta conque sea superior al maximo valor del peso en alguna de las aristas

    private static List< List< Node>> ady = new ArrayList< List< Node>>(); //lista de adyacencia
    private int distancia[] = new int[MAX];          //distancia[ u ] distancia de vÃ©rtice inicial a vÃ©rtice con ID = u
    private boolean visitado[] = new boolean[MAX];   //para vÃ©rtices visitados
    private static PriorityQueue< Node> Q = new PriorityQueue<Node>(); //priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope
    private static int V;                                      //numero de vertices
    private int previo[] = new int[MAX];              //para la impresion de caminos
    private boolean dijkstraEjecutado;

    public GrafoTramos(Punto[] V) {
        this.V = V.length;
        for (int i = 0; i <= V.length; ++i) {
            ady.add(new ArrayList<Node>()); //inicializamos lista de adyacencia
        }
        dijkstraEjecutado = false;
    }

    //En el caso de java usamos una clase que representara el pair de C++
    public class Node implements Comparable<Node> {

        int first;
        int second;

        Node(int d, int p) {                          //constructor
            this.first = d;
            this.second = p;
        }

        public int compareTo(Node other) {              //es necesario definir un comparador para el correcto funcionamiento del PriorityQueue
            if (second > other.second) {
                return 1;
            }
            if (second == other.second) {
                return 0;
            }
            return -1;
        }
    };

    //funciÃ³n de inicializaciÃ³n
    private void init() {
        for (int i = 0; i <= V; ++i) {
            distancia[i] = INF;  //inicializamos todas las distancias con valor infinito
            visitado[i] = false; //inicializamos todos los vÃ©rtices como no visitados
            previo[i] = -1;      //inicializamos el previo del vertice i con -1
        }
    }

    //Paso de relajacion
    private void relajacion(int actual, int adyacente, int peso) {
        //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
        if (distancia[actual] + peso < distancia[adyacente]) {
            distancia[adyacente] = distancia[actual] + peso;  //relajamos el vertice actualizando la distancia
            previo[adyacente] = actual;                         //a su vez actualizamos el vertice previo
            Q.add(new Node(adyacente, distancia[adyacente])); //agregamos adyacente a la cola de prioridad
        }
    }

    void dijkstra(int inicial) {
        init(); //inicializamos nuestros arreglos
        Q.add(new Node(inicial, 0)); //Insertamos el vÃ©rtice inicial en la Cola de Prioridad
        distancia[inicial] = 0;      //Este paso es importante, inicializamos la distancia del inicial como 0
        int actual, adyacente, peso;
        while (!Q.isEmpty()) {                   //Mientras cola no este vacia
            actual = Q.element().first;            //Obtengo de la cola el nodo con menor peso, en un comienzo serÃ¡ el inicial
            Q.remove();                           //Sacamos el elemento de la cola
            if (visitado[actual]) {
                continue; //Si el vÃ©rtice actual ya fue visitado entonces sigo sacando elementos de la cola
            }
            visitado[actual] = true;         //Marco como visitado el vÃ©rtice actual

            for (int i = 0; i < ady.get(actual).size(); ++i) { //reviso sus adyacentes del vertice actual
                adyacente = ady.get(actual).get(i).first;   //id del vertice adyacente
                peso = ady.get(actual).get(i).second;        //peso de la arista que une actual con adyacente ( actual , adyacente )
                if (!visitado[adyacente]) {        //si el vertice adyacente no fue visitado
                    relajacion(actual, adyacente, peso); //realizamos el paso de relajacion
                }
            }
        }

        System.out.printf("Distancias mas cortas iniciando en vertice %d\n", inicial);
        for (int i = 1; i <= V; ++i) {
            System.out.printf("Vertice %d , distancia mas corta = %d\n", i, distancia[i]);
        }
        dijkstraEjecutado = true;
    }

    public void addEdge(int origen, int destino, int peso, boolean dirigido) {
        ady.get(origen).add(new Node(destino, peso));    //grafo diridigo
        if (!dirigido) {
            ady.get(destino).add(new Node(origen, peso)); //no dirigido
        }
    }

    public void removeEdge(int origen, int destino, int peso, boolean dirigido) {
        ady.get(origen).remove(new Node(destino, peso));    //grafo diridigo
        if (!dirigido) {
            ady.get(destino).remove(new Node(origen, peso)); //no dirigido
        }
    }

    public Boolean existsEdge(int origen, int destino, int peso, boolean dirigido) {
        Boolean b = false;
        Node e = new Node(destino, peso);                         //constructor
        List<Node> aux = new ArrayList<Node>();
        aux = ady.get(origen);
        int i = 0;
        if (ady.get(origen).size() > 0) {
            while (i < aux.size()) {
                if (aux.get(i).first == destino) {
                    b = true;
                    i = aux.size();
                }
                i++;
            }

        }

        return b;
    }

    void printShortestPath() {
        if (!dijkstraEjecutado) {
            System.out.println("Es necesario ejecutar el algorithmo de Dijkstra antes de poder imprimir el camino mas corto");
            return;
        }
        Scanner sc = new Scanner(System.in);      //para lectura de datos
        System.out.println("\n**************Impresion de camino mas corto**************");
        System.out.printf("Ingrese vertice destino: ");
        int destino;
        destino = sc.nextInt();
        print(destino);
        System.out.printf("\n");
    }

    //Impresion del camino mas corto desde el vertice inicial y final ingresados
    void print(int destino) {
        if (previo[destino] != -1) //si aun poseo un vertice previo
        {
            print(previo[destino]);  //recursivamente sigo explorando
        }
        System.out.printf("%d ", destino);        //terminada la recursion imprimo los vertices recorridos
    }

    public int getNumberOfVertices() {
        return V;
    }

    public void setNumberOfVertices(int numeroDeVertices) {
        V = numeroDeVertices;
    }
}
