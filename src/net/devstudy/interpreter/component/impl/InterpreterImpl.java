package net.devstudy.interpreter.component.impl;

import net.devstudy.interpreter.component.ContextInterpeter;
import net.devstudy.interpreter.component.Interpreter;
import net.devstudy.interpreter.component.OperationTreeBuilder;
import net.devstudy.interpreter.component.SourceLineReader;
import net.devstudy.interpreter.model.Operation;
import net.devstudy.interpreter.model.SourceLine;

public class InterpreterImpl implements Interpreter {
    private final SourceLineReader sourceLineReader;
    private final OperationTreeBuilder operationTreeBuilder;
    private final ContextInterpeter contextInterpeter;

    public InterpreterImpl(SourceLineReader sourceLineReader,
                           OperationTreeBuilder operationTreeBuilder,
                           ContextInterpeter contextInterpeter) {
        this.sourceLineReader = sourceLineReader;
        this.operationTreeBuilder = operationTreeBuilder;
        this.contextInterpeter = contextInterpeter;
    }

    @Override
    public void interpret(String fileName) {
        SourceLine[] sourceLines = sourceLineReader.read(fileName);
        Operation[] operations = operationTreeBuilder.buildTree(sourceLines);
        for (Operation operation : operations) {
            contextInterpeter.interpret(operation);
        }
    }
}