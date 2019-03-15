package com.borber;
public class Clear{
    public char[] clear_Char(char[] First,char S){
        char[] R = new char[First.length];
        for (int i=0,Length=First.length;i < Length;++i) R[i] = S;
        return R;
    }
}