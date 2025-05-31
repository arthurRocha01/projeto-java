# Diretórios
SRC_DIR = src
BIN_DIR = bin
RESOURCES_DIR = $(SRC_DIR)/resources
TARGET_RESOURCES = $(BIN_DIR)/resources

# Classe principal com nome completo (incluindo pacote)
MAIN_CLASS = br.com.poo.AppMain

# Lista todos os arquivos .java (inclui subpastas)
SOURCES := $(shell find $(SRC_DIR) -name "*.java")

# Regra padrão
all: compile copy-resources

# Compilação
compile:
	@echo "Compilando arquivos Java..."
	@mkdir -p $(BIN_DIR)
	@javac -d $(BIN_DIR) --module-path $(BIN_DIR) $(SOURCES)

# Cópia de recursos
copy-resources:
	@echo "Copiando recursos..."
	@mkdir -p $(TARGET_RESOURCES)
	@cp $(RESOURCES_DIR)/* $(TARGET_RESOURCES)/

# Execução
run: all
	@echo "Executando $(MAIN_CLASS)..."
	@echo "\n-------------------------"
	@java -cp $(BIN_DIR) $(MAIN_CLASS)

# Limpeza dos arquivos .class e recursos copiados
clean:
	@echo "Limpando arquivos compilados..."
	@rm -rf $(BIN_DIR)/*

.PHONY: all compile run clean copy-resources

