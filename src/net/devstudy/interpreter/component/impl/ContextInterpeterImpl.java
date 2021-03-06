package net.devstudy.interpreter.component.impl;

import net.devstudy.interpreter.component.ContextInterpeter;
import net.devstudy.interpreter.component.OperationInterpeter;
import net.devstudy.interpreter.exception.SyntaxInterpreterException;
import net.devstudy.interpreter.model.Operation;

import java.util.List;

public class ContextInterpeterImpl implements ContextInterpeter {

    private final List<OperationInterpeter> operationInterpeters;

    public ContextInterpeterImpl(List<OperationInterpeter> operationInterpeters) {
        this.operationInterpeters = operationInterpeters;
    }

    @Override
    public void interpret(Operation operation) {
        SourceLineHelper.setSourceLine(operation.getSourceLine());
        for (OperationInterpeter operationInterpeter : operationInterpeters) {
            if (operationInterpeter.isSupport(operation)) {
                operationInterpeter.interpreter(operation);
                return;
            }
        }
        throw new SyntaxInterpreterException("Undefined command: " + operation.getSourceLine().getLine());
    }
}
