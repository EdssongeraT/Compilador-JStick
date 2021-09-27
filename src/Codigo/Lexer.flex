package Codigo;
import static Codigo.Tokens.*;
import Interfaces.InterfazPrin;
%%
%public
%class Lexer
%type Tokens
%line
%column
L=[a-zA-Z]+
D=[0-9]+
S=["_","-","/","(",")","{","}","=","<",">","*","+","&","|",".","%","[","]","#"]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
compare  {lexeme=yytext();return compare;}
fn  {lexeme=yytext();return fn;}
then  {lexeme=yytext();return then;}
decimal {lexeme=yytext();return decimal;}
key  {lexeme=yytext();return key;}
btn  {lexeme=yytext();return btn;}
kill {lexeme=yytext();return kill;}
resurrect {lexeme=yytext();return resurrect;}
setFunc {lexeme=yytext();return setFunc;}
getFunc {lexeme=yytext();return getFunc;}
hold {lexeme=yytext();return hold;}
pressed {lexeme=yytext();return pressed;}
invert {lexeme=yytext();return invert;}
getX {lexeme=yytext();return getX;}
getY {lexeme=yytext();return getY;}
positive {lexeme=yytext();return positive;}
negative {lexeme=yytext();return negative;}
nes {lexeme=yytext();return nes;}
joy {lexeme=yytext();return joy;}
bool {lexeme=yytext();return bool;}
loop {lexeme=yytext();return loop;}
shatter {lexeme=yytext();return shatter;}
swing {lexeme=yytext();return swing;}
option {lexeme=yytext();return option;}
verify {lexeme=yytext();return verify;}
cast {lexeme=yytext();return cast;}
message {lexeme=yytext();return message;}
getP {lexeme=yytext();return getP;}
reco {lexeme=yytext();return reco;}
getPort {lexeme=yytext();return getPort;}
Array {lexeme=yytext();return Array;}
main {lexeme=yytext();return main;}
word {lexeme=yytext();return word;}
exception {lexeme=yytext();return exception;}
getButton {lexeme=yytext();return getButton;}
enable {lexeme=yytext();return enable;}
podri {lexeme=yytext();return podri;}
{espacio} {/*Ignore*/}
"¡¡".* {/*Ignore*/}
"\n" {lexeme=yytext();return line;}
"&"  {lexeme=yytext();return and;}
"|"  {lexeme=yytext();return not;}
"||" {lexeme=yytext();return or;}
"+"  {lexeme=yytext();return suma;}
"-"  {lexeme=yytext();return resta;}
"*"  {lexeme=yytext();return multi;}
"/"  {lexeme=yytext();return div;}
"%"  {lexeme=yytext();return mod;}
"+="  {lexeme=yytext();return sum_asig;}
"-="  {lexeme=yytext();return res_asig;}
"="  {lexeme=yytext();return asig;}
")"  {lexeme=yytext();return par_der;}
"("  {lexeme=yytext();return par_izq;}
"{"  {lexeme=yytext();return llave_izq;}
"}" {lexeme=yytext();return llave_der;}
"["  {lexeme=yytext();return corch_izq;}
"]"  {lexeme=yytext();return corch_der;}
">="  {lexeme=yytext();return mayor_igual;}
"<="  {lexeme=yytext();return menor_igual;}
"<"  {lexeme=yytext();return menor;}
">"  {lexeme=yytext();return mayor;}
"<>"  {lexeme=yytext();return dif;}
"=="  {lexeme=yytext();return comp;}//comparacion booleana
"++"  {lexeme=yytext();return incremento;}
"--"  {lexeme=yytext();return decremento;}
"@"{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
(({L}|{D})*) {lexeme=yytext();return Cadena;}
("-"{D})|{D}+ {lexeme=yytext(); return Entero;}
("-"{D}"."{D}+)|({D}"."{D}+) {lexeme=yytext(); return Flotante;}
 . {InterfazPrin.txtResultado.append("Error léxico: Símbolo no válido: "+yytext()+" en Linea: "+(yyline+1)+"\n");
System.out.println("Error léxico: "+yytext()+" Linea: "+yyline + " Columna: "+ yycolumn); return ERROR;}

