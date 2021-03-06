package net.devstudy.interpreter.component;

import net.devstudy.interpreter.model.Operation;
import net.devstudy.interpreter.model.SourceLine;

import java.util.List;

public interface OperationTreeBuilder {

    List<Operation> buildTree(List<SourceLine> sourceLines);
}
