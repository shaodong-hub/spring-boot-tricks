#!/bin/bash
# --------------------------------------------------------------------------
# 基本的配置
# JAR 的名称
app_name="tricks"
# 当前工程的路径
apprun_path="/apprun/tricks"
# 要更新的工程路径
new_project_path="/apprun/tricks_v2"
# 其他配置
format_date=$(date "+%Y-%m-%d")
echo "current data: ${format_date}"
# --------------------------------------------------------------------------
# 代码自检
# --------------------------------------------------------------------------
# 检查 /etc/systemd/system 目录下是否有 .service 文件, 没有就新建并赋予权限
# 系统服务基础路径
base_system_path="/etc/systemd/system/${app_name}.service"
echo "systemd: ${base_system_path}"
if [ ! -f ${new_project_path} ]; then
  sudo cp ${apprun_path}/${app_name}.service ${base_system_path}
  chmod 755 ${base_system_path}
fi
# --------------------------------------------------------------------------
# 重命名管理平台并赋权限
if [ $# == 0 ]; then
  echo "给新工程赋权限......"
  chown -R apprun:apprun ${new_project_path}
  chmod 755 ${new_project_path}/*
  echo "备份旧文件......"
  mv ${apprun_path} ${apprun_path}_"${format_date}"
  mv ${new_project_path} ${apprun_path}
fi
# --------------------------------------------------------------------------
# 开始更新管理平台
sudo systemctl daemon-reload
sudo systemctl enable ${app_name}
sudo systemctl restart ${app_name}
echo "finish!............"

