package codigo;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class gui extends javax.swing.JFrame {

    private String smovs = ""; //variable que contiene los movimientos de cada jugador;
    public String sEstadisticas = ""; //stats del juego,
    private int movs = 0; //contador del numero de movimientos transcurridos
    private int[][] gato = new int[3][3]; //matriz de los movimientos hechos
    private boolean jugando = false; //contiene si el juego ya empezo
    private boolean pensando = false; //contiene si la maquina esta realizando su movimiento
    juego Juego = new juego();  //se crea un objeto de tipo Juego
    Thread jugar;  //se crea un hilo que se va a llamar jugar (aun no definido cual sera el hilo
    //variables para stats
    private int ganadosJ = 0; //juegos ganados de la persona
    private int ganadosM = 0; //juegos ganados de la maquina
    private int empatados = 0; //juegos empatados
    private String nombre = "";
    private String nombre_anterior = "";

    public String estadisticas() {
        sEstadisticas = " ==== Estadisticas ==== ";
        sEstadisticas += "\n" + nombre + ", has ganado: " + ganadosJ + " partidas";
        sEstadisticas += "\nY yo he ganado: " + ganadosM + " partidas";
        sEstadisticas += "\nHemos empatado: " + empatados + " partidas";
        // txtEstadisticas.setText(sEstadisticas);
        return sEstadisticas;
    }

    //funcion para volver el juego a su estado inicial*************************
    private void inicializar() {
        //solo si hay un juego iniciado ya
        if (jugando == true) {
            //se detiene el hilo
            jugar.stop();
        }
        //se marca que ya no hay mas juegos
        jugando = false;
        pensando = false;
        Juego.terminar = true;
        Juego.mitiro = false;
        //botones sin marcas 'X' u 'O'
        jPos0.setText("");
        jPos1.setText("");
        jPos2.setText("");
        jPos3.setText("");
        jPos4.setText("");
        jPos5.setText("");
        jPos6.setText("");
        jPos7.setText("");
        jPos8.setText("");

        //area de texto lista para empezar
        txtTexto.setText(nombre + ", inicia porfavor ^^");
        smovs = "==Movimientos Realizados==\n";

        estadisticas();

        //desbloquea los botones
        jPos0.setEnabled(true);
        jPos1.setEnabled(true);
        jPos2.setEnabled(true);
        jPos3.setEnabled(true);
        jPos4.setEnabled(true);
        jPos5.setEnabled(true);
        jPos6.setEnabled(true);
        jPos7.setEnabled(true);
        jPos8.setEnabled(true);

        //numero de movimientos en cero
        movs = 0;

        //matriz en 0
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                gato[x][y] = 0;
            }
        }
    }

    //colocar valor en la matriz gato******************************************
    private void marcarMatriz(int jugador, int pos) {
        //boolean valido= ComprobarVacio(pos);
        //if(valido==true){
        switch (jugador) {
            //si juega la persona
            case 1:
                switch (pos) {
                    case 0:
                        smovs += "Tu: 0,0\n";
                        gato[0][0] = 1;
                        jPos0.setText("O");
                        jPos0.setEnabled(false);
                        break;
                    case 1:
                        smovs += "Tu: 0,1\n";
                        gato[0][1] = 1;
                        jPos1.setText("O");
                        jPos1.setEnabled(false);
                        break;
                    case 2:
                        smovs += "Tu: 0,2\n";
                        gato[0][2] = 1;
                        jPos2.setText("O");
                        jPos2.setEnabled(false);
                        break;
                    case 3:
                        smovs += "Tu: 1,0\n";
                        gato[1][0] = 1;
                        jPos3.setText("O");
                        jPos3.setEnabled(false);
                        break;
                    case 4:
                        smovs += "Tu: 1,1\n";
                        gato[1][1] = 1;
                        jPos4.setText("O");
                        jPos4.setEnabled(false);
                        break;
                    case 5:
                        smovs += "Tu: 1,2\n";
                        gato[1][2] = 1;
                        jPos5.setText("O");
                        jPos5.setEnabled(false);
                        break;
                    case 6:
                        smovs += "Tu: 2,0\n";
                        gato[2][0] = 1;
                        jPos6.setText("O");
                        jPos6.setEnabled(false);
                        break;
                    case 7:
                        smovs += "Tu: 2,1\n";
                        gato[2][1] = 1;
                        jPos7.setText("O");
                        jPos7.setEnabled(false);
                        break;
                    case 8:
                        smovs += "Tu: 2,2\n";
                        gato[2][2] = 1;
                        jPos8.setText("O");
                        jPos8.setEnabled(false);
                        break;
                }
                break;
            //si juega la maquina
            case 2:
                switch (pos) {
                    case 0:
                        smovs += "Yo: 0,0\n";
                        gato[0][0] = 2;
                        jPos0.setText("X");
                        jPos0.setEnabled(false);
                        break;
                    case 1:
                        smovs += "Yo: 0,1\n";
                        gato[0][1] = 2;
                        jPos1.setText("X");
                        jPos1.setEnabled(false);
                        break;
                    case 2:
                        smovs += "Yo: 0,2\n";
                        gato[0][2] = 2;
                        jPos2.setText("X");
                        jPos2.setEnabled(false);
                        break;
                    case 3:
                        smovs += "Yo: 1,0\n";
                        gato[1][0] = 2;
                        jPos3.setText("X");
                        jPos3.setEnabled(false);
                        break;
                    case 4:
                        smovs += "Yo: 1,1\n";
                        gato[1][1] = 2;
                        jPos4.setText("X");
                        jPos4.setEnabled(false);
                        break;
                    case 5:
                        smovs += "Yo: 1,2\n";
                        gato[1][2] = 2;
                        jPos5.setText("X");
                        jPos5.setEnabled(false);
                        break;
                    case 6:
                        smovs += "Yo: 2,0\n";
                        gato[2][0] = 2;
                        jPos6.setText("X");
                        jPos6.setEnabled(false);
                        break;
                    case 7:
                        smovs += "Yo: 2,1\n";
                        gato[2][1] = 2;
                        jPos7.setText("X");
                        jPos7.setEnabled(false);
                        break;
                    case 8:
                        smovs += "Yo: 2,2\n";
                        gato[2][2] = 2;
                        jPos8.setText("X");
                        jPos8.setEnabled(false);
                        break;
                }
                break;
        }
        //}
        //else

    }

    //comprueba si es un movimiento valido*************************************
    private boolean ComprobarVacio(int pos) {
        boolean valido = false;
        switch (pos) {
            case 0:
                if (gato[0][0] == 0) {
                    valido = true;
                }
                break;
            case 1:
                if (gato[0][1] == 0) {
                    valido = true;
                }
                break;
            case 2:
                if (gato[0][2] == 0) {
                    valido = true;
                }
                break;
            case 3:
                if (gato[1][0] == 0) {
                    valido = true;
                }
                break;
            case 4:
                if (gato[1][1] == 0) {
                    valido = true;
                }
                break;
            case 5:
                if (gato[1][2] == 0) {
                    valido = true;
                }
                break;
            case 6:
                if (gato[2][0] == 0) {
                    valido = true;
                }
                break;
            case 7:
                if (gato[2][1] == 0) {
                    valido = true;
                }
                break;
            case 8:
                if (gato[2][2] == 0) {
                    valido = true;
                }
                break;
        }
        return valido;
    }

    //Funcion empate determina si el juego sera declarado un empate************
    private void empate() {
        //si ya no hay mas movimientos posibles y nadie ha ganado el ju8ego es empate
        if (movs == 9) {
            JOptionPane.showMessageDialog(null, "Bien jugado pero esto es un empate D:");
            txtTexto.setText("El juego es declarado un... Empate :O");
            //el juego se reestablece
            // inicializar();
            empatados++;
            estadisticas();
            jugar.stop();
            jugando = false;
        }
    }

    //recorrer en horizontal a ver quien gano :O***************************
    private void ganoUserH(int jugador) {
        switch (jugador) {
            //si juega la persona
            case 1:
                if (gato[0][0] == 1 && gato[0][1] == 1 && gato[0][2] == 1) {
                    JOptionPane.showMessageDialog(null, "Ganaste ¬¬");
                    ganadosJ++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;

                } else if (gato[1][0] == 1 && gato[1][1] == 1 && gato[1][2] == 1) {
                    JOptionPane.showMessageDialog(null, "Te deje ganar ^^");
                    ganadosJ++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;

                } else if (gato[2][0] == 1 && gato[2][1] == 1 && gato[2][2] == 1) {
                    JOptionPane.showMessageDialog(null, "D: No puedo creerlo");
                    ganadosJ++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;

                } else {
                    break;
                }
            // break;
            //si juega la maquina
            case 2:
                if (gato[0][0] == 2 && gato[0][1] == 2 && gato[0][2] == 2) {
                    JOptionPane.showMessageDialog(null, "¡Coff Coff!");
                    ganadosM++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;

                } else if (gato[1][0] == 2 && gato[1][1] == 2 && gato[1][2] == 2) {
                    JOptionPane.showMessageDialog(null, "^^, Vuelve a jugar");
                    ganadosM++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;

                } else if (gato[2][0] == 2 && gato[2][1] == 2 && gato[2][2] == 2) {
                    JOptionPane.showMessageDialog(null, "Yo gano :D");
                    ganadosM++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;

                } else {
                    break;
                }
            //break;
        }
    }

    //recorrer en vertical a ver quien gano :O**************************
    private void ganoUserV(int jugador) {
        switch (jugador) {
            //si juega la persona
            case 1:
                if (gato[0][0] == 1 && gato[1][0] == 1 && gato[2][0] == 1) {
                    JOptionPane.showMessageDialog(null, "Ganaste ¬¬");
                    ganadosJ++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else if (gato[0][1] == 1 && gato[1][1] == 1 && gato[2][1] == 1) {
                    JOptionPane.showMessageDialog(null, "Ganaste ¬¬");
                    ganadosJ++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else if (gato[0][2] == 1 && gato[1][2] == 1 && gato[2][2] == 1) {
                    JOptionPane.showMessageDialog(null, "Ganaste ¬¬");
                    ganadosJ++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else {
                    break;
                }
            //si juega la maquina
            case 2:
                if (gato[0][0] == 2 && gato[1][0] == 2 && gato[2][0] == 2) {
                    JOptionPane.showMessageDialog(null, "Wow!, ganee!");
                    ganadosM++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else if (gato[0][1] == 2 && gato[1][1] == 2 && gato[2][1] == 2) {
                    JOptionPane.showMessageDialog(null, "^^!");
                    ganadosM++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else if (gato[0][2] == 2 && gato[1][2] == 2 && gato[2][2] == 2) {
                    JOptionPane.showMessageDialog(null, "Sigue esforzandote (=");
                    ganadosM++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else {
                    break;
                }

        }
    }

    //recorrer en diagonal a ver quien gano :O**************************
    private void ganoUserD(int jugador) {
        switch (jugador) {
            //si juega la persona
            case 1:
                if (gato[0][0] == 1 && gato[1][1] == 1 && gato[2][2] == 1) {
                    JOptionPane.showMessageDialog(null, "Ganaste ¬¬");
                    ganadosJ++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else if (gato[0][2] == 1 && gato[1][1] == 1 && gato[2][0] == 1) {
                    JOptionPane.showMessageDialog(null, "Ganaste ¬¬");
                    ganadosJ++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else {
                    break;
                }
            //si juega la maquina
            case 2:
                if (gato[0][0] == 2 && gato[1][1] == 2 && gato[2][2] == 2) {
                    JOptionPane.showMessageDialog(null, "Estuvo cerca :O");
                    ganadosM++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else if (gato[0][2] == 2 && gato[1][1] == 2 && gato[2][0] == 2) {
                    JOptionPane.showMessageDialog(null, "Fue un juego epico :O");
                    ganadosM++;
                    estadisticas();
                    jugar.stop();
                    jugando = false;
                    break;
                } else {
                    break;
                }

        }
    }

    private void ganoUser(int jugador) {
        ganoUserH(jugador);
        ganoUserD(jugador);
        ganoUserV(jugador);
    }

    private void centrarVentana() {
        // Se obtienen las dimensiones en pixels de la pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        // Se obtienen las dimensiones en pixels de la ventana.
        Dimension ventana = getSize();
        // Una cuenta para situar la ventana en el centro de la pantalla.
        setLocation((pantalla.width - ventana.width) / 2,
                (pantalla.height - ventana.height) / 2);
    }

    public gui() {
        initComponents();
        centrarVentana();
        inicializar();

        try {
            while (nombre.equals("")) {
                nombre = JOptionPane.showInputDialog("¿Cual es tu nombre?");
            }
            inicializar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sólo tenias que poner tu nombre... bye", "Juego de gato", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPos0 = new javax.swing.JButton();
        jPos1 = new javax.swing.JButton();
        jPos2 = new javax.swing.JButton();
        jPos3 = new javax.swing.JButton();
        jPos4 = new javax.swing.JButton();
        jPos5 = new javax.swing.JButton();
        jPos6 = new javax.swing.JButton();
        jPos7 = new javax.swing.JButton();
        jPos8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego de gato");
        setResizable(false);

        jPos0.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos0.setOpaque(false);
        jPos0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos0ActionPerformed(evt);
            }
        });

        jPos1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos1ActionPerformed(evt);
            }
        });

        jPos2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos2ActionPerformed(evt);
            }
        });

        jPos3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos3ActionPerformed(evt);
            }
        });

        jPos4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos4ActionPerformed(evt);
            }
        });

        jPos5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos5ActionPerformed(evt);
            }
        });

        jPos6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos6ActionPerformed(evt);
            }
        });

        jPos7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos7ActionPerformed(evt);
            }
        });

        jPos8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jPos8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPos8ActionPerformed(evt);
            }
        });

        txtTexto.setColumns(20);
        txtTexto.setEditable(false);
        txtTexto.setLineWrap(true);
        txtTexto.setRows(2);
        txtTexto.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtTexto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPos0, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPos5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPos6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPos7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPos8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPos0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPos3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPos4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPos5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPos6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPos7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPos8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem1.setText("Juego Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Ver");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem5.setText("Estadisticas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem6.setText("Resumen");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Opciones");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setText("Nuevo Jugador");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem4.setText("Reestablecer Estadisticas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Acerca de...");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem7.setText("Creditos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jPos0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos0ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true;
            movs++; //aumenta el numero de movimientos
            marcarMatriz(1, 0);
            ganoUserH(1);
            ganoUserV(1);
            ganoUserD(1);
            empate(); //comprueba si es empate
            jugar = new Thread(Juego); //se define el hilo
            jugar.start(); //y se inicia :D
        } else { //si ya hay un juego
            if (pensando == false) {
                pensando = true;
                movs++; //aumenta el numero de movimientos
                marcarMatriz(1, 0);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate(); //comprueba si es empate
                jugar.resume();
            }
        }
    }//GEN-LAST:event_jPos0ActionPerformed

    //aqui toda la explicacion de los botones :O
    private void jPos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos1ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true; //se marca que ya hay un juego iniciado
            movs++;  //se aumenta el numero de movimientos xq se realizo uno
            marcarMatriz(1, 1); //se marca en la matriz en donde se tiro
            //el primer valor es el jugador y el segundo el tiro
            //jugador 1 hombre, jugador 2 maquina. las posiciones van de 0-9
            ganoUserH(1); //se comprueba si el usuario gano en horizontal
            ganoUserV(1); //se comprueba si el usuario gano en vertical
            ganoUserD(1); //se comprueba si el usuario gano en diagonal
            empate(); //se comprueba si se empato
            jugar = new Thread(Juego); //se define el hilo (objeto) del tipo de la subclase Juego
            jugar.start(); //y se inicia :D
        } else {    //si ya hay un juego iniciado
            if (pensando == false) { //si la maquina no esta realizando su movimiento
                pensando = true;
                movs++; //de aqui es lo mismo que si no excepto por el jugando= true
                marcarMatriz(1, 1);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate();
                jugar.resume(); //y se inicia :D (osea que se reanuda) los 9 botones son iguales excepto por la posicion
                //en la que se marca la matriz :O
            }
        }


    }//GEN-LAST:event_jPos1ActionPerformed

    private void jPos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos2ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true;
            movs++;
            marcarMatriz(1, 2);
            ganoUserH(1);
            ganoUserV(1);
            ganoUserD(1);
            empate();
            jugar = new Thread(Juego); //se define el hilo
            jugar.start(); //y se inicia :D
        } else {
            if (pensando == false) {
                pensando = true;
                movs++;
                marcarMatriz(1, 2);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate();
                jugar.resume(); //y se inicia :D
            }
        }

    }//GEN-LAST:event_jPos2ActionPerformed

    private void jPos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos3ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true;
            movs++;
            marcarMatriz(1, 3);
            ganoUserH(1);
            ganoUserV(1);
            ganoUserD(1);
            empate();
            jugar = new Thread(Juego); //se define el hilo
            jugar.start(); //y se inicia :D
        } else {
            if (pensando == false) {
                pensando = true;
                movs++;
                marcarMatriz(1, 3);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate();
                jugar.resume(); //y se inicia :D
            }
        }
    }//GEN-LAST:event_jPos3ActionPerformed

    private void jPos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos4ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true;
            movs++;
            marcarMatriz(1, 4);
            ganoUserH(1);
            ganoUserV(1);
            ganoUserD(1);
            empate();
            jugar = new Thread(Juego); //se define el hilo
            jugar.start(); //y se inicia :D
        } else {
            if (pensando == false) {
                pensando = true;
                movs++;
                marcarMatriz(1, 4);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate();
                jugar.resume(); //y se inicia :D
            }
        }
    }//GEN-LAST:event_jPos4ActionPerformed

    private void jPos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos5ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true;
            movs++;
            marcarMatriz(1, 5);
            ganoUserH(1);
            ganoUserV(1);
            ganoUserD(1);
            empate();
            jugar = new Thread(Juego); //se define el hilo
            jugar.start(); //y se inicia :D
        } else {
            if (pensando == false) {
                pensando = true;
                movs++;
                marcarMatriz(1, 5);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate();
                jugar.resume(); //y se inicia :D
            }
        }

    }//GEN-LAST:event_jPos5ActionPerformed

    private void jPos6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos6ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true;
            movs++;
            marcarMatriz(1, 6);
            ganoUserH(1);
            ganoUserV(1);
            ganoUserD(1);
            empate();
            jugar = new Thread(Juego); //se define el hilo
            jugar.start(); //y se inicia :D
        } else {
            if (pensando == false) {
                pensando = true;
                movs++;
                marcarMatriz(1, 6);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate();
                jugar.resume(); //y se inicia :D
            }
        }
    }//GEN-LAST:event_jPos6ActionPerformed

    private void jPos7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos7ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true;
            movs++;
            marcarMatriz(1, 7);
            ganoUserH(1);
            ganoUserV(1);
            ganoUserD(1);
            empate();
            jugar = new Thread(Juego); //se define el hilo
            jugar.start(); //y se inicia :D
        } else {
            if (pensando == false) {
                pensando = true;
                movs++;
                marcarMatriz(1, 7);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate();
                jugar.resume(); //y se inicia :D
            }
        }
    }//GEN-LAST:event_jPos7ActionPerformed

    private void jPos8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPos8ActionPerformed
        if (jugando == false) { //si no hay un juego ya entonces se marca que se inicia un juego
            pensando = true;
            jugando = true;
            movs++;
            marcarMatriz(1, 8);
            ganoUserH(1);
            ganoUserV(1);
            ganoUserD(1);
            empate();
            jugar = new Thread(Juego); //se define el hilo
            jugar.start(); //y se inicia :D
        } else {
            if (pensando == false) {
                pensando = true;
                movs++;
                marcarMatriz(1, 8);
                ganoUserH(1);
                ganoUserV(1);
                ganoUserD(1);
                empate();
                jugar.resume(); //y se inicia :D
            }
        }
    }//GEN-LAST:event_jPos8ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //empezar un juego nuevo
        inicializar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            nombre_anterior= nombre;
            nombre = "";
            while (nombre.equals("")) {
                nombre = JOptionPane.showInputDialog("¿Cual es tu nombre?");
            }
            ganadosJ = 0;
            ganadosM = 0;
            empatados = 0;

            inicializar();
        } catch (Exception e) {
            nombre= nombre_anterior;
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        stats dialogo = new stats(new javax.swing.JFrame(), true);
        dialogo.sEstadisticas = sEstadisticas;
        dialogo.setEstadisticas();
        dialogo.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        resume dialog = new resume(new javax.swing.JFrame(), false);
        dialog.smovs = smovs;
        dialog.setResumen();
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        int resp= JOptionPane.showConfirmDialog(null, "Esta opción reestablecerá"
                + "las estadísticas del juego,\n¿Deseas continuar?");
        switch(resp){
            case 0:
                ganadosJ = 0;
                ganadosM = 0;
                empatados = 0;
                estadisticas();
                JOptionPane.showMessageDialog(null, "Hecho","Juego de gato",JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Bien, sigamos así :D","Juego de gato",JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                break;
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

       JOptionPane.showMessageDialog(null, "Integrantes: \n"
               + "Jessy Sebastian Arellano Soriano\n"
               + "Alfredo Misrain Ramos Parra");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new gui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jPos0;
    private javax.swing.JButton jPos1;
    private javax.swing.JButton jPos2;
    private javax.swing.JButton jPos3;
    private javax.swing.JButton jPos4;
    private javax.swing.JButton jPos5;
    private javax.swing.JButton jPos6;
    private javax.swing.JButton jPos7;
    private javax.swing.JButton jPos8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables

    public class juego implements Runnable {

        String texto = "";
        public boolean terminar = true;
        public boolean mitiro = false;

        public void run() {
            while (terminar) {
                puedoGanar();
                comprobarPeligro();
                pre();
                comprobar4();
                aleatorio();

                if (mitiro == true) {
                    ganoUser(2);
                    mitiro = false;
                    pensando = false;
                    jugar.suspend();
                }


            }

        }

        private void pre() {

            if (((gato[0][0] == 1) && (gato[1][1] == 2) && (gato[2][2] == 1) && (gato[2][1] == 0) && (mitiro == false))
                    || ((gato[0][2] == 1) && (gato[1][1] == 2) && (gato[2][0] == 1) && (mitiro == false))) {
                pensando();
                texto = "Humm... Detecto una jugada peligrosa...";
                txtTexto.setText(texto);
                esperar(800);
                texto += ".";
                txtTexto.setText(texto);
                esperar(800);
                texto += ".";
                txtTexto.setText(texto);
                esperar(800);
                texto += ".";
                txtTexto.setText(texto);
                esperar(800);
                texto = "Listo :D Tu turno ^^";
                txtTexto.setText(texto);

                marcarMatriz(2, 7);
                mitiro = true;
                movs++;
            }

            if (((gato[0][0] == 1) && (gato[1][1] == 2) && (gato[1][2] == 1) && (mitiro == false) && (gato[2][1] == 0))
                    || ((gato[1][2] == 1) && (gato[1][1] == 2) && (gato[2][0] == 1) && (mitiro == false) && (gato[2][1] == 0))) {
                pensando();
                texto = "Bla, bla";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(300);
                texto = "Adelante...";
                txtTexto.setText(texto);

                marcarMatriz(2, 7);
                mitiro = true;
                movs++;
            }

            if ((gato[2][1] == 1) && (gato[1][1] == 2) && (gato[1][2] == 1) && (mitiro == false) && (gato[0][2] == 0)) {
                pensando();
                texto = "ZzZ.";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(300);
                texto = "Veamos que puedes hacer ^^";
                txtTexto.setText(texto);

                marcarMatriz(2, 2);
                mitiro = true;
                movs++;
            }

            if ((gato[2][1] == 1) && (gato[1][1] == 2) && (gato[0][0] == 1) && (mitiro == false) && (gato[2][0] == 0)) {
                pensando();
                texto = "ZzZ.";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(300);
                texto = "Veamos que puedes hacer ^^";
                txtTexto.setText(texto);

                marcarMatriz(2, 6);
                mitiro = true;
                movs++;
            }

            if (((gato[0][1] == 1) && (gato[1][1] == 2) && (gato[2][2] == 1) && (mitiro == false) && (gato[1][0] == 0))
                    || ((gato[2][1] == 1) && (gato[1][1] == 2) && (gato[0][2] == 1) && (mitiro == false) && (gato[1][0] == 0))) {
                texto = "La, la, la.";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(300);
                texto = "Vas ^^";
                txtTexto.setText(texto);

                marcarMatriz(2, 3);
                mitiro = true;
                movs++;
            }

            if ((gato[1][0] == 1) && (gato[1][1] == 2) && (gato[2][2] == 1) && (mitiro == false) && (gato[0][1] == 0)) {
                pensando();
                texto = "Uhm.";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(300);
                texto = "Eso estuvo facil ^^";
                txtTexto.setText(texto);

                marcarMatriz(2, 1);
                mitiro = true;
                movs++;
            }

            if ((gato[0][0] == 2) && (gato[1][1] == 1) && (gato[2][2] == 1) && (mitiro == false) && (gato[2][0] == 0)) {
                pensando();
                texto = "Interesante.";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(200);
                texto += ".";
                txtTexto.setText(texto);
                esperar(300);
                texto = "¡Habre tirado bien? ^^";
                txtTexto.setText(texto);

                marcarMatriz(2, 6);
                mitiro = true;
                movs++;
            }

        }

        //para ver si ya se jugo en el centro, y si no, tirar ahi
        private void comprobar4() {
            if (gato[1][1] == 0 && mitiro == false) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("¿Te estas dejando ganar? :O");
                mitiro = true;
                movs++;
            }
        }

        //para ver si el jugador tiene alguna jugada de gane en horizontal
        private void comprobarPeligroH() {

            //primera fila
            if (gato[0][0] == 1 && gato[0][1] == 1 && mitiro == false && gato[0][2] == 0) {
                pensando();
                marcarMatriz(2, 2);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[0][0] == 1 && gato[0][2] == 1 && mitiro == false && gato[0][1] == 0) {
                pensando();
                marcarMatriz(2, 1);
                txtTexto.setText("¡Listo! Tu turno :D");
                mitiro = true;
                movs++;
            }

            if (gato[0][1] == 1 && gato[0][2] == 1 && mitiro == false && gato[0][0] == 0) {
                pensando();
                marcarMatriz(2, 0);
                txtTexto.setText("Mi turno está hecho, va el tuyo :O");
                mitiro = true;
                movs++;
            }

            //segunda fila
            if (gato[1][0] == 1 && gato[1][1] == 1 && mitiro == false && gato[1][2] == 0) {
                pensando();
                marcarMatriz(2, 5);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[1][0] == 1 && gato[1][2] == 1 && mitiro == false && gato[1][1] == 0) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("¡Listo! Tu turno :D");
                mitiro = true;
                movs++;
            }

            if (gato[1][1] == 1 && gato[1][2] == 1 && mitiro == false && gato[1][0] == 0) {
                pensando();
                marcarMatriz(2, 3);
                txtTexto.setText("Mi turno está hecho, va el tuyo :O");
                mitiro = true;
                movs++;
            }

            //tercera fila
            if (gato[2][0] == 1 && gato[2][1] == 1 && mitiro == false && gato[2][2] == 0) {
                pensando();
                marcarMatriz(2, 8);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[2][0] == 1 && gato[2][2] == 1 && mitiro == false && gato[2][1] == 0) {
                pensando();
                marcarMatriz(2, 7);
                txtTexto.setText("¡Listo! Tu turno :D");
                mitiro = true;
                movs++;
            }

            if (gato[2][1] == 1 && gato[2][2] == 1 && mitiro == false && gato[2][0] == 0) {
                pensando();
                marcarMatriz(2, 6);
                txtTexto.setText("Mi turno está hecho, va el tuyo :O");
                mitiro = true;
                movs++;
            }
        }

        //para ver si el jugador tiene alguna jugada de gane en diagonal
        private void comprobarPeligroV() {
            //primera columna
            if (gato[0][0] == 1 && gato[1][0] == 1 && mitiro == false && gato[2][0] == 0) {
                pensando();
                marcarMatriz(2, 6);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[0][0] == 1 && gato[2][0] == 1 && mitiro == false && gato[1][0] == 0) {
                pensando();
                marcarMatriz(2, 3);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[1][0] == 1 && gato[2][0] == 1 && mitiro == false && gato[0][0] == 0) {
                pensando();
                marcarMatriz(2, 0);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            //segunda columna
            if (gato[0][1] == 1 && gato[1][1] == 1 && mitiro == false && gato[2][1] == 0) {
                pensando();
                marcarMatriz(2, 7);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[0][1] == 1 && gato[2][1] == 1 && mitiro == false && gato[1][1] == 0) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[1][1] == 1 && gato[2][1] == 1 && mitiro == false && gato[0][1] == 0) {
                pensando();
                marcarMatriz(2, 1);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            //tercera columna
            if (gato[0][2] == 1 && gato[1][2] == 1 && mitiro == false && gato[2][2] == 0) {
                pensando();
                marcarMatriz(2, 8);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[0][2] == 1 && gato[2][2] == 1 && mitiro == false && gato[1][2] == 0) {
                pensando();
                marcarMatriz(2, 5);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[1][2] == 1 && gato[2][2] == 1 && mitiro == false && gato[0][2] == 0) {
                pensando();
                marcarMatriz(2, 2);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }
        }

        //para ver si el jugador tiene alguna jugada de gane en vertical
        //suele estar demas porque en realidad siempre se evita este peligro...
        ///pero por si acaso D:
        private void comprobarPeligroD() {

            //primera diagonal: \
            if (gato[0][0] == 1 && gato[1][1] == 1 && mitiro == false && gato[2][2] == 0) {
                pensando();
                marcarMatriz(2, 8);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[0][0] == 1 && gato[2][2] == 1 && mitiro == false && gato[1][1] == 0) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[1][1] == 1 && gato[2][2] == 1 && mitiro == false && gato[0][0] == 0) {
                pensando();
                marcarMatriz(2, 0);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            //segunda diagonal /
            if (gato[0][2] == 1 && gato[1][1] == 1 && mitiro == false && gato[2][0] == 0) {
                pensando();
                marcarMatriz(2, 6);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[0][2] == 1 && gato[2][0] == 1 && mitiro == false && gato[1][1] == 0) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[1][1] == 1 && gato[2][0] == 1 && mitiro == false && gato[0][2] == 0) {
                pensando();
                marcarMatriz(2, 2);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }
        }

        private void comprobarPeligro() {
            comprobarPeligroH();
            comprobarPeligroD();
            comprobarPeligroV();
        }

        private void puedoGanarH() {
            //primera fila
            if (gato[0][0] == 2 && gato[0][1] == 2 && mitiro == false && gato[0][2] == 0) {
                pensando();
                marcarMatriz(2, 2);
                txtTexto.setText("Pues... Gane!!! :D");
                mitiro = true;
                movs++;
            }

            if (gato[0][0] == 2 && gato[0][2] == 2 && mitiro == false && gato[0][1] == 0) {
                pensando();
                marcarMatriz(2, 1);
                txtTexto.setText(":O Ya acabo el juego y... Gane :D");
                mitiro = true;
                movs++;
            }

            if (gato[0][1] == 2 && gato[0][2] == 2 && mitiro == false && gato[0][0] == 0) {
                pensando();
                marcarMatriz(2, 0);
                txtTexto.setText("Jugaste bien humano, pero te falta mucho aun ^^");
                mitiro = true;
                movs++;
            }

            //segunda fila
            if (gato[1][0] == 2 && gato[1][1] == 2 && mitiro == false && gato[1][2] == 0) {
                pensando();
                marcarMatriz(2, 5);
                txtTexto.setText("Game Over :D Yo gano :D");
                mitiro = true;
                movs++;
            }

            if (gato[1][0] == 2 && gato[1][2] == 2 && mitiro == false && gato[1][1] == 0) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("No te sientas mal, jugaste bien :O");
                mitiro = true;
                movs++;
            }

            if (gato[1][1] == 2 && gato[1][2] == 2 && mitiro == false && gato[1][0] == 0) {
                pensando();
                marcarMatriz(2, 3);
                txtTexto.setText("Vaya, pense que perderia... Pero gane :D");
                mitiro = true;
                movs++;
            }

            //tercera fila
            if (gato[2][0] == 2 && gato[2][1] == 2 && mitiro == false && gato[2][2] == 0) {
                pensando();
                marcarMatriz(2, 8);
                txtTexto.setText("Por un breve momento tuve miedo D: Pero he ganado ^^");
                mitiro = true;
                movs++;
            }

            if (gato[2][0] == 2 && gato[2][2] == 2 && mitiro == false && gato[2][1] == 0) {
                pensando();
                marcarMatriz(2, 7);
                txtTexto.setText("¡Hay un ganadoooooor!, y soy yo :D");
                mitiro = true;
                movs++;
            }

            if (gato[2][1] == 2 && gato[2][2] == 2 && mitiro == false && gato[2][0] == 0) {
                pensando();
                marcarMatriz(2, 6);
                txtTexto.setText("Vuelve a intentarlo :D");
                mitiro = true;
                movs++;
            }
        }

        private void puedoGanarV() {
            //primera columna
            if (gato[0][0] == 2 && gato[1][0] == 2 && mitiro == false && gato[2][0] == 0) {
                pensando();
                marcarMatriz(2, 6);
                txtTexto.setText(":O Yo gane :O");
                mitiro = true;
                movs++;
            }

            if (gato[0][0] == 2 && gato[2][0] == 2 && mitiro == false && gato[1][0] == 0) {
                pensando();
                marcarMatriz(2, 3);
                txtTexto.setText("Has jugado bien, pero no lo suficiente D:");
                mitiro = true;
                movs++;
            }

            if (gato[1][0] == 2 && gato[2][0] == 2 && mitiro == false && gato[0][0] == 0) {
                pensando();
                marcarMatriz(2, 0);
                txtTexto.setText("¿Estabas distraido, cierto?");
                mitiro = true;
                movs++;
            }

            //segunda columna
            if (gato[0][1] == 2 && gato[1][1] == 2 && mitiro == false && gato[2][1] == 0) {
                pensando();
                marcarMatriz(2, 7);
                txtTexto.setText("Este es el fin u.u ¡Gane! :D");
                mitiro = true;
                movs++;
            }

            if (gato[0][1] == 2 && gato[2][1] == 2 && mitiro == false && gato[1][1] == 0) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("Vas bien humano...");
                mitiro = true;
                movs++;
            }

            if (gato[1][1] == 2 && gato[2][1] == 2 && mitiro == false && gato[0][1] == 0) {
                pensando();
                marcarMatriz(2, 1);
                txtTexto.setText("Simplemente yo... Gane :D");
                mitiro = true;
                movs++;
            }

            //tercera columna
            if (gato[0][2] == 2 && gato[1][2] == 2 && mitiro == false && gato[2][2] == 0) {
                pensando();
                marcarMatriz(2, 8);
                txtTexto.setText("He ganado, pero no presumiré de mi victoria ^^");
                mitiro = true;
                movs++;
            }

            if (gato[0][2] == 2 && gato[2][2] == 2 && mitiro == false && gato[1][2] == 0) {
                pensando();
                marcarMatriz(2, 5);
                txtTexto.setText("¡Casi me ganas!");
                mitiro = true;
                movs++;
            }

            if (gato[1][2] == 2 && gato[2][2] == 2 && mitiro == false && gato[0][2] == 0) {
                pensando();
                marcarMatriz(2, 2);
                txtTexto.setText("Hiciste que sufriera por momentos D:");
                mitiro = true;
                movs++;
            }
        }

        private void puedoGanarD() {
            //primera diagonal: \
            if (gato[0][0] == 2 && gato[1][1] == 2 && mitiro == false && gato[2][2] == 0) {
                pensando();
                marcarMatriz(2, 8);
                txtTexto.setText("Sin comentarios u.u Gané fácilmente...");
                mitiro = true;
                movs++;
            }

            if (gato[0][0] == 2 && gato[2][2] == 2 && mitiro == false && gato[1][1] == 0) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("Lamento decirte que... He ganado :D");
                mitiro = true;
                movs++;
            }

            if (gato[1][1] == 2 && gato[2][2] == 2 && mitiro == false && gato[0][0] == 0) {
                pensando();
                marcarMatriz(2, 0);
                txtTexto.setText("Ouch... Te gané");
                mitiro = true;
                movs++;
            }

            //segunda diagonal /
            if (gato[0][2] == 2 && gato[1][1] == 2 && mitiro == false && gato[2][0] == 0) {
                pensando();
                marcarMatriz(2, 6);
                txtTexto.setText("No te sientas mal, has jugado bien ^^");
                mitiro = true;
                movs++;
            }

            if (gato[0][2] == 2 && gato[2][0] == 2 && mitiro == false && gato[1][1] == 0) {
                pensando();
                marcarMatriz(2, 4);
                txtTexto.setText("¿Qué te pasó? Esperaba más de ti D:");
                mitiro = true;
                movs++;
            }

            if (gato[1][1] == 2 && gato[2][0] == 2 && mitiro == false && gato[0][2] == 0) {
                pensando();
                marcarMatriz(2, 2);
                txtTexto.setText("Juguemos otra vez :D");
                mitiro = true;
                movs++;
            }
        }

        private void puedoGanar() {
            puedoGanarH();
            puedoGanarV();
            puedoGanarD();
        }

        private void aleatorio() {
            int tiro = 0;
            for (int fila = 0; fila < 3; fila++) {
                for (int col = 0; col < 3; col++) {
                    if (gato[fila][col] == 0 && mitiro == false) {
                        pensando();
                        marcarMatriz(2, tiro);
                        txtTexto.setText("Me duermo... D:");
                        mitiro = true;
                        movs++;
                        fila = 4;
                        col = 4;
                        //break;
                    }
                    tiro++;
                }
            }
        }

        private void pensando() {
            esperar(200);

            texto = "Pensando.";
            txtTexto.setText(texto);
            esperar(300);

            texto += ".";
            txtTexto.setText(texto);
            esperar(300);

            texto += ".";
            txtTexto.setText(texto);
            esperar(400);
        }

        private void esperar(int tiempo) {
            try {
                Thread.sleep(tiempo);
            } catch (Exception e) {
            }
        }
    }
}
