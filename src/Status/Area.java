package Status;

import java.util.*;
import java.io.*;

public enum Area {
    ALL("All"),
    BRACKETS("Brackets"),                                      //対となる括弧
    CLASS_CALL("ClassCall"),                                   //クラス名
    CLASS_DIAGRAM_TO_SOURCE_CODE("ClassDiagramToSourceCode"),  //機械的導出
    CLASS_DIAGRAM("ClassDiagram"),                             //クラス図とソースコード
    CODINGSTYLE_CLASSNAME("CodingStyleClassName"),             //キャメルケース(クラス名)
    CODINGSTYLE_METHOD("CodingStyleMethod"),                   //キャメルケース(メソッド名)
    CODINGSTYLE_VARIABLE("CodingStyleVariable"),               //キャメルケース(変数)
    COMMENT("Comment"),                                        //コメント
    COMPILE_AND_RUN("CompileAndRun"),                          //コンパイル
    CONSTRUCTOR("Constructor"),                                //コンストラクタ
    FOR("For"),                                                //for制御文
    INDENT("Indent"),                                          //インデント
    LITERAL_STRING("LiteralString"),                           //文字列リテラル
    METHOD("Method"),                                          //メソッドのふるまい
    OPERATOR_ASSIGNMENT("OperatorAssignment"),                 //代入演算子
    OPERATOR_COMPARISON("OperatorComparison"),                 //比較演算子
    OPERATOR_LOGIC("OperatorLogic"),                           //論理演算子
    PARAMETER_TYPE("ParameterType"),                           //仮引数の型
    PARAMETER("Parameter"),                                    //仮引数
    PROGRAM_ARGUMENTS("ProgramArguments"),                     //実引数
    RETURN_TYPE("ReturnType"),                                 //返却値の型
    RETURN_VALUE_DEFAULT("ReturnValueDefault"),                //返却値の初期値
    RETURN_VALUE("ReturnValue"),                               //返却値
    SCOPE("Scope"),                                            //スコープ
    SOURCE_CODE_TO_CLASS_DIAGRAM("SourceCodeToClassDiagram"),  //クラス図
    STATIC_METHOD_CALL("StaticMethodCall"),                    //メソッドの呼び出し
    VARIABLE_SENTENCE("VariableSentence"),                     //変数宣言
    VARIABLE("Variable"),                                      //変数

    TRANSFER_ARGUMENT("Transfer_Argument");                    //実引数と仮引数(受け渡し)

    
    private final String className;
    private Area(final String className){
        this.className = className;
    } 
    public String getClassName(){
        return this.className;
    }
}