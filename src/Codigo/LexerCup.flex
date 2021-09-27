package Codigo;
import static Codigo.sym.*;
import java_cup.runtime.Symbol;
import Interfaces.InterfazPrin;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z]+
D=[0-9]+
S=["_","-","/","(",")","{","}","=","<",">","*","+","&","|",".","%","[","]","#"]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
compare  {return new Symbol(sym.compare, yychar, yyline, yytext());}
fn  {return new Symbol(sym.fn, yychar, yyline, yytext());}
then  {{return new Symbol(sym.then, yychar, yyline, yytext());}}
decimal {return new Symbol(sym.decimal, yychar, yyline, yytext());}
key  {return new Symbol(sym.key, yychar, yyline, yytext());}
btn  {return new Symbol(sym.btn, yychar, yyline, yytext());}
kill {return new Symbol(sym.kill, yychar, yyline, yytext());}
resurrect {return new Symbol(sym.resurrect, yychar, yyline, yytext());}
setFunc {return new Symbol(sym.setFunc, yychar, yyline, yytext());}
getFunc {return new Symbol(sym.getFunc, yychar, yyline, yytext());}
hold {return new Symbol(sym.hold, yychar, yyline, yytext());}
pressed {return new Symbol(sym.pressed, yychar, yyline, yytext());}
invert {return new Symbol(sym.invert, yychar, yyline, yytext());}
getX {return new Symbol(sym.getX, yychar, yyline, yytext());}
getY {return new Symbol(sym.getY, yychar, yyline, yytext());}
positive {return new Symbol(sym.positive, yychar, yyline, yytext());}
negative {return new Symbol(sym.negative, yychar, yyline, yytext());}
nes {return new Symbol(sym.nes, yychar, yyline, yytext());}
joy {return new Symbol(sym.joy, yychar, yyline, yytext());}
bool {return new Symbol(sym.bool, yychar, yyline, yytext());}
loop {return new Symbol(sym.loop, yychar, yyline, yytext());}
shatter {return new Symbol(sym.shatter, yychar, yyline, yytext());}
swing {return new Symbol(sym.swing, yychar, yyline, yytext());}
option {return new Symbol(sym.option, yychar, yyline, yytext());}
verify {return new Symbol(sym.verify, yychar, yyline, yytext());}
cast {return new Symbol(sym.cast, yychar, yyline, yytext());}
message {return new Symbol(sym.message, yychar, yyline, yytext());}
getP {return new Symbol(sym.getP, yychar, yyline, yytext());}
reco {return new Symbol(sym.reco, yychar, yyline, yytext());}
getPort {return new Symbol(sym.getPort, yychar, yyline, yytext());}
Array {return new Symbol(sym.Array, yychar, yyline, yytext());}
main {return new Symbol(sym.main, yychar, yyline, yytext());}
word {return new Symbol(sym.word, yychar, yyline, yytext());}
exception {return new Symbol(sym.exception, yychar, yyline, yytext());}
getButton {return new Symbol(sym.getButton, yychar, yyline, yytext());}
enable {return new Symbol(sym.enable, yychar, yyline, yytext());}
podri {return new Symbol(sym.podri, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"¡¡".* {/*Ignore*/}
"&"  {return new Symbol(sym.and, yychar, yyline, yytext());}
"|"  {return new Symbol(sym.not, yychar, yyline, yytext());}
"||" {return new Symbol(sym.or, yychar, yyline, yytext());}
"+"  {return new Symbol(sym.suma, yychar, yyline, yytext());}
"-"  {return new Symbol(sym.resta, yychar, yyline, yytext());}
"*"  {return new Symbol(sym.multi, yychar, yyline, yytext());}
"/"  {return new Symbol(sym.div, yychar, yyline, yytext());}
"%"  {return new Symbol(sym.mod, yychar, yyline, yytext());}
"+="  {return new Symbol(sym.sum_asig, yychar, yyline, yytext());}
"-="  {return new Symbol(sym.res_asig, yychar, yyline, yytext());}
"="  {return new Symbol(sym.asig, yychar, yyline, yytext());}
")"  {return new Symbol(sym.par_der, yychar, yyline, yytext());}
"("  {return new Symbol(sym.par_izq, yychar, yyline, yytext());}
"{"  {return new Symbol(sym.llave_izq, yychar, yyline, yytext());}
"}" {return new Symbol(sym.llave_der, yychar, yyline, yytext());}
"["  {return new Symbol(sym.corch_izq, yychar, yyline, yytext());}
"]"  {return new Symbol(sym.corch_der, yychar, yyline, yytext());}
">="  {return new Symbol(sym.mayor_igual, yychar, yyline, yytext());}
"<="  {return new Symbol(sym.menor_igual, yychar, yyline, yytext());}
"<"  {return new Symbol(sym.menor, yychar, yyline, yytext());}
">"  {return new Symbol(sym.mayor, yychar, yyline, yytext());}
"<>"  {return new Symbol(sym.dif, yychar, yyline, yytext());}
"=="  {return new Symbol(sym.comp, yychar, yyline, yytext());}//comparacion booleana
"++"  {return new Symbol(sym.incremento, yychar, yyline, yytext());}
"--"  {return new Symbol(sym.decremento, yychar, yyline, yytext());}
"@"{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
(({L}|{D})*) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}
("-"{D})|{D}+ {return new Symbol(sym.Entero, yychar, yyline, yytext());}
("-"{D}"."{D}+)|({D}"."{D}+) {return new Symbol(sym.Flotante, yychar, yyline, yytext());}
 . {InterfazPrin.txtResultado.append("Error léxico: Símbolo no válido: "+yytext()+" en Linea: "+(yyline+1)+"\n");
System.out.println("Error léxico: "+yytext()+" Linea: "+yyline + " Columna: "+ yycolumn); {return new Symbol(sym.ERROR, yychar, yyline, yytext());}}


