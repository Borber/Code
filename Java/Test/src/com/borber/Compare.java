package com.borber;
public class Compare{
    public boolean Char_Ign(char First,char Second){
        if (First == Second|| First + 'A'-'a'==Second || First + 'a'-'A' == Second)
        return true;
        return false;
    }
    public boolean Str_Char(String First,char[] Second){
        if(First.length()!=Second.length) return false;
        for(int i = 0;i < First.length();++i)
        if(First.charAt(i) != Second[i]) return false;
        return true;
    }
}