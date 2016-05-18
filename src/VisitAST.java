interface VisitAST {
    void visitProgram(ProgramNode node);
    void visitBoard(BoardNode node);
    void visitPieces(PiecesNode node);
    void visitSetup(SetupNode node);
    void visitRules(RulesNode node);
    void visitWinCondition(WinConditionNode node);
    void visitMethod(MethodNode node);
    void visitSize(SizeNode node);
    void visitBoardParam(BoardParamNode node);
    void visitStmt(StmtNode node);
    void visitPlayer(PlayersNode node);
    void visitTurn(TurnNode node);
    void visitTurnDistribution(TurnDistributionNode node);
    void visitWinCND(WinCNDNode node);
    void visitHeight(HeightNode node);
    void visitWidth(WidthNode node);
}