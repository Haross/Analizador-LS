package analizadorlexico;
import static analizadorlexico.Token.*;
%%
%class Lexer
%type Token
L=[a-z]
D=[0-9]
white=[,\n]
%{
    public String save;
%}
%%
{white} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return igual;}
"+" {return suma;}
{L} {save = yytext(); return Variable;}
{D} {save = yytext(); return Numero;}
"*" {return multiplicacion;}
"-" {return resta;}
"/" {return division;}
. {return ERROR;}
