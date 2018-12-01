/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x0;

/**
 *
 * @author Jarfsoft
 */
public class JuegoX0 {
    private char j1,j2;
    private char[][] tablero= new char[3][3];
    public JuegoX0(char j1, char j2){
        this.j1=j1;
        this.j2=j2;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tablero[i][j]=' ';
            }
        }
    }
    public boolean marcarJugada(char jugador, int f, int c){
        if(tablero[f][c]==' '){
            tablero[f][c]=jugador;
            return true;
        }else
            return false;
    }
    public void imprimirTablero(){
        System.out.println(" "+tablero[0][0]+" | "+tablero[0][1]+" | "+tablero[0][2]+" \n---+---+---\n "+tablero[1][0]+" | "+tablero[1][1]+" | "+tablero[1][2]+" \n---+---+---\n "+tablero[2][0]+" | "+tablero[2][1]+" | "+tablero[2][2]);
    }
    public boolean gane(char j){
        int re;
        for(int x=0;x<3;x++){
            re=0;
            for(int y=0;y<3;y++){
                if(tablero[x][y]==j)
                    re++;
            }
            if(re==3)
                return true;
        }
        for(int y=0;y<3;y++){
            re=0;
            for(int x=0;x<3;x++){
                if(tablero[x][y]==j)
                    re++;
            }
            if(re==3)
                return true;
        }
        if(tablero[0][0]==j)
            if(tablero[1][1]==j)
                if(tablero[2][2]==j)
                    return true;
        if(tablero[0][2]==j)
            if(tablero[1][1]==j)
                if(tablero[2][0]==j)
                    return true;
        return false;
    }
}
