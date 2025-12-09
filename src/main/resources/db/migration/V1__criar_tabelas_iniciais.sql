BEGIN;

CREATE TYPE status_enum AS ENUM (
  'FINALIZADO',
  'ABERTO',
  'EM_ANDAMENTO',
  'CANCELADO'
);

CREATE TYPE tipo_atendimento_enum AS ENUM (
  'REMOTO',
  'PRESENCIAL'
);

CREATE TABLE tb_cliente (
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  telefone VARCHAR(50)
);

CREATE TABLE tb_tecnico (
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255)
);

CREATE TABLE tb_atendimento (
  id BIGSERIAL PRIMARY KEY,
  descricao VARCHAR(1000),
  status status_enum NOT NULL DEFAULT 'ABERTO',
  tipo_atendimento tipo_atendimento_enum NOT NULL,
  cliente_id BIGINT NOT NULL,
  tecnico_id BIGINT,  -- <<< AGORA É NULO
  abertura TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
  version BIGINT NOT NULL DEFAULT 0,
  CONSTRAINT fk_atendimento_cliente FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id) ON DELETE RESTRICT,
  CONSTRAINT fk_atendimento_tecnico FOREIGN KEY (tecnico_id) REFERENCES tb_tecnico(id) ON DELETE SET NULL
);

CREATE INDEX idx_atendimento_cliente ON tb_atendimento (cliente_id);
CREATE INDEX idx_atendimento_tecnico ON tb_atendimento (tecnico_id);
CREATE INDEX idx_atendimento_abertura ON tb_atendimento (abertura);

COMMIT;
