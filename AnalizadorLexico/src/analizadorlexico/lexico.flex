package analizadorlexico;
import static analizadorlexico.Token.*;
%%
%class Lexer
%type Token
L=[a-zA-Z_]
D=[0-9]
white=[ \t\r\n]
C= [#]
CO = [%]
%{
    public String save;
%}
%%
<YYINITIAL> hola {save = yytext(); return PR;}
<YYINITIAL> adios {save = yytext(); return PR;}
<YYINITIAL> aparecer {save = yytext(); return PR;}
<YYINITIAL> desaparecer {save = yytext(); return PR;}
<YYINITIAL> proceso {save = yytext(); return PR;}
<YYINITIAL> principal {save = yytext(); return PR;}
<YYINITIAL> comprimir {save = yytext(); return PR;}
<YYINITIAL> libreria {save = yytext(); return PR;}
<YYINITIAL> aplicar {save = yytext(); return PR;}
<YYINITIAL> super {save = yytext(); return PR;}
<YYINITIAL> devolver {save = yytext(); return PR;}
<YYINITIAL> si {save = yytext(); return PR;}
<YYINITIAL> sino {save = yytext(); return PR;}
<YYINITIAL> mientras {save = yytext(); return PR;}
<YYINITIAL>{
{white} {/*Ignore*/}
"//".* {/*Ignore*/}
"(" {return PI;}
")" {return PD;}
"=" {return igual;}
"+" {return suma;}
["'!''¡'"]?{D}+[.] {D}+ {save = yytext(); return Numero;}
["'!''¡'"]?{D}+ {save = yytext(); return Numero;}
"*" {return multiplicacion;}
"-" {return resta;}
"/" {return division;}
"==" {return EQUALS;}
"!=" {return DIF;}
{CO}({L}|{D})*{CO} {save = yytext();return CO;}
{C}({L}|{D})*{C} {save = yytext();return CAD;}
{L} ({L}|{D})* {save = yytext();return ID;}

. {return ERROR;}
}





