package Status;

import java.util.*;
import java.io.*;

public enum Area {
    ALL("All"),
    BRACKETS("Brackets"),                                      //�΂ƂȂ銇��
    CLASS_CALL("ClassCall"),                                   //�N���X��
    CLASS_DIAGRAM_TO_SOURCE_CODE("ClassDiagramToSourceCode"),  //�@�B�I���o
    CLASS_DIAGRAM("ClassDiagram"),                             //�N���X�}�ƃ\�[�X�R�[�h
    CODINGSTYLE_CLASSNAME("CodingStyleClassName"),             //�L�������P�[�X(�N���X��)
    CODINGSTYLE_METHOD("CodingStyleMethod"),                   //�L�������P�[�X(���\�b�h��)
    CODINGSTYLE_VARIABLE("CodingStyleVariable"),               //�L�������P�[�X(�ϐ�)
    COMMENT("Comment"),                                        //�R�����g
    COMPILE_AND_RUN("CompileAndRun"),                          //�R���p�C��
    CONSTRUCTOR("Constructor"),                                //�R���X�g���N�^
    FOR("For"),                                                //for���䕶
    INDENT("Indent"),                                          //�C���f���g
    LITERAL_STRING("LiteralString"),                           //�����񃊃e����
    METHOD("Method"),                                          //���\�b�h�̂ӂ�܂�
    OPERATOR_ASSIGNMENT("OperatorAssignment"),                 //������Z�q
    OPERATOR_COMPARISON("OperatorComparison"),                 //��r���Z�q
    OPERATOR_LOGIC("OperatorLogic"),                           //�_�����Z�q
    PARAMETER_TYPE("ParameterType"),                           //�������̌^
    PARAMETER("Parameter"),                                    //������
    PROGRAM_ARGUMENTS("ProgramArguments"),                     //������
    RETURN_TYPE("ReturnType"),                                 //�ԋp�l�̌^
    RETURN_VALUE_DEFAULT("ReturnValueDefault"),                //�ԋp�l�̏����l
    RETURN_VALUE("ReturnValue"),                               //�ԋp�l
    SCOPE("Scope"),                                            //�X�R�[�v
    SOURCE_CODE_TO_CLASS_DIAGRAM("SourceCodeToClassDiagram"),  //�N���X�}
    STATIC_METHOD_CALL("StaticMethodCall"),                    //���\�b�h�̌Ăяo��
    VARIABLE_SENTENCE("VariableSentence"),                     //�ϐ��錾
    VARIABLE("Variable"),                                      //�ϐ�

    TRANSFER_ARGUMENT("Transfer_Argument");                    //�������Ɖ�����(�󂯓n��)

    
    private final String className;
    private Area(final String className){
        this.className = className;
    } 
    public String getClassName(){
        return this.className;
    }
}