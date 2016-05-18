// Define a grammar called Hello
grammar PUTIN;
program         : board pieces setup rules wincondition method*;

board           : 'Board' '[' size boardparam* ']' ;
pieces          : 'Pieces' '[' stmt* ']' ;
setup           : 'Setup' '[' players stmt* ']' ;
rules           : 'Rules' '[' turn+ turndistribution ']' ;
wincondition    : 'WinConditions' '[' wincnd* ']';
method          : type? ID '(' (nextm (',' nextnextm)*)? ')' '{' stmt* returnstmt? '}';

size            : height width ;
boardparam      : illigaltiles
                | specialtiles ;
stmt            : assignmentstmt
                | ifstmt
                | repeatwhilestmt
                | repeatstmt
                | optionsstmt
                | foreachstmt
                | methodcall;
players         : players1
                | players2 ;
turn            : 'Turn' ID '{' stmt* '}' ;
turndistribution: 'TurnDistribution' '{' stmt* '}' ;
wincnd          : ifstmt
                | optionsstmt;
type            : TYPE_NUMBER
                | TYPE_TEXT
                | TYPE_BOOLEAN
                | TYPE_PLAYER
                | TYPE_PIECE
                | TYPE_LIST
                | TYPE_COORDINATE ;

nextm           : type ID ;
nextnextm       : type ID ;

height          : 'Height' '=' INT ';' ;
width           : 'Width' '=' INT ';' ;
illigaltiles    : 'IllegalTiles' '=' '(' coordinate (',' coordinate)* ')' ';' ;
specialtiles    : 'SpecialTiles' ID '=' '(' coordinate (',' coordinate)* ')' ';' ;
assignmentstmt  : assignmentstmt1
                | assignmentstmt2
                | assignmentstmt3 ;
ifstmt          : 'If' '(' expression ')' '{' stmt* '}' elsif* els? ;
repeatwhilestmt : 'RepeatWhile' '(' expression ')' '{' stmt* '}' ;
repeatstmt      : 'Repeat' '(' INT ')' '{' stmt* '}' ;
optionsstmt     : 'Options' '(' expression ')' '{' option+ def? '}' ;
returnstmt      : 'Return' expression ';' ;
foreachstmt     : 'ForEach' '(' type 'In' ID ')' '{' stmt* '}' ;
methodcall      : (mc)* ID '(' (value (',' value)*)? ')' ';' ;
players1        : 'Players' '=' INT ';' ;
players2        : 'Players' '=' '(' ID (',' ID)* ')' ';' ;

piecetype       : '{' stmt* '}' ;
expression      : relation r* ;
r               : op=(OP_AND | OP_OR) relation ;
relation        : add a* ;
a               : op=(OP_EQUALS | OP_NOTEQUALS | OP_LESSTHAN | OP_LARGERTHAN | OP_EQUALORLESSTHAN | OP_EQUALORLARGERTHAN) add ;
add             : mult m* ;
m               : op=(OP_PLUS | OP_MINUS) mult ;
mult            : unary u* ;
u               : op=(OP_MULTIPLY | OP_DIVIDE | OP_MOD) unary ;
unary           : n* negation ;
n               : op=(OP_PLUS | OP_MINUS) ;
negation        : t* term ;
t               : op=OP_NOT ;
term            : value
                | '(' expression ')' ;
elsif           : 'ElseIf' '(' expression ')' '{' stmt* '}' ;
els             : 'Else' '{' stmt* '}' ;
option          : 'Option' expression ':' '{' stmt* '}';
def             : 'Default' ':' '{' stmt* '}';
assignmentstmt1 : type ID '=' piecetype ;
assignmentstmt2 : type ID '=' expression ';' ;
assignmentstmt3 : ID('.' ID)* '=' expression ';' ;
mc              : mc1 | mc2 ;
mc1             : ID '.' ;
mc2             : ID '(' (value (',' value)*)? ')' '.' ;

coordinate      : '(' INT ',' INT ')' ;

value           : number
                | TEXT
                | BOOL
                | coordinate
                | list
                | stmtmethod
                | singlemove;

singlemove      : DIRECTION expression ;
number          : INT
                | DOUBLE ;
stmtmethod      : stmtm ('.' stmtm)* ;
list            : '(' (value (',' value)*)? ')' ;

stmtm           : stmtm2
                | stmtm1 ;
stmtm1          : ID ('.' ID)* ('(' (value (',' value)*)? ')')? ;
stmtm2          : ID ('.' ID)* ;

DOUBLE          : INT '.' INT ;
TYPE_NUMBER             : 'Number' ;
TYPE_TEXT               : 'Text' ;
TYPE_BOOLEAN            : 'Boolean' ;
TYPE_PLAYER             : 'Player' ;
TYPE_PIECE              : 'Piece' ;
TYPE_LIST               : 'List' ;
TYPE_COORDINATE         : 'Coordinate' ;
OP_AND                  : 'And';
OP_OR                   : 'Or';
OP_EQUALS               : 'Equals';
OP_NOTEQUALS            : 'NotEquals';
OP_LESSTHAN             : 'LessThan';
OP_LARGERTHAN           : 'LargerThan';
OP_EQUALORLESSTHAN      : 'EqualOrLessThan';
OP_EQUALORLARGERTHAN    : 'EqualOrLargerThan';
OP_MULTIPLY             : '*';
OP_DIVIDE               : '/';
OP_MOD                  : 'Mod'
                        | '%';
OP_PLUS                 : '+';
OP_MINUS                : '-';
OP_NOT                  : '!';

DIRECTION       : 'H'
                | 'Horizontal'
                | 'V'
                | 'Vertical'
                | 'R'
                | 'Range' ;
TEXT            : '"' ( '"' '"' | ~('"'|'\r'|'\n'))* '"';
BOOL            : 'True'
                | 'False' ;
INT             : '0'..'9'+ ;
ID              : ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;
WS              : [ \t\r\n]+ -> skip ;
COMMENT_MUlT    : '/*' .*? '*/' -> skip ;
COMMENT         : '//' ~[\r\n]* -> skip ;