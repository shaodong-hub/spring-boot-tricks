#!/bin/bash
# --------------------------------------------------------------------------
# The name of the application
app_name="tricks"
# 当前工程的路径
apprun_path="/apprun/${app_name}"
# 要更新的工程路径
new_project_path=$(cd $(dirname "$0") || exit; pwd)
# 其他配置
format_date=$(date "+%Y-%m-%d_%H:%M:%S")
echo "current data: ${format_date}"
# --------------------------------------------------------------------------
# 文件自检
if [ ! -f "${new_project_path}/${app_name}.jar" ]; then
    echo "${new_project_path}/${app_name}.jar not found!"
    exit
fi
if [ ! -f "${new_project_path}/${app_name}.conf" ]; then
    echo "${new_project_path}/${app_name}.conf not found!"
    exit
fi
if [ ! -f "${new_project_path}/application-prod.properties" ]; then
    echo "${new_project_path}/application-prod.properties not found!"
    exit
fi
# --------------------------------------------------------------------------
# 文件夹自检
bak_folder="/apprun/bak"
if [ ! -d "$bak_folder" ]; then
  echo "bak folder not found, create $bak_folder...... "
  mkdir "$bak_folder"
  chown -R apprun:apprun "$bak_folder"
fi
# 代码自检
if [ ! -d "${apprun_path}" ]; then
  echo "${apprun_path} not found, I guess it's the first deployment ...... "
fi
# --------------------------------------------------------------------------
# 检查 /etc/systemd/system 目录下是否有 .service 文件, 没有就新建并赋予权限
# 系统服务基础路径
base_system_path="/etc/systemd/system/${app_name}.service"
echo "systemd: ${base_system_path}"
if [ ! -f "${base_system_path}" ]; then
  echo "${base_system_path} not found, I guess it's the first deployment ...... "
  echo "move ${new_project_path}/${app_name}.service to ${base_system_path}"
  echo "chmod 755 ${base_system_path}"
  exit
#  sudo cp "${new_project_path}"/${app_name}.service ${base_system_path}
#  chmod 755 ${base_system_path}
fi
# --------------------------------------------------------------------------
# 重命名管理平台并赋权限
if [ $# == 0 ]; then
  echo "给新工程赋权限......"
  chown -R apprun:apprun "${new_project_path}"
  chmod 755 "${new_project_path}"/*
  if [ -d "${apprun_path}" ]; then
    echo "备份旧文件......"
    mv ${apprun_path} ${bak_folder}/${app_name}_"${format_date}"
  fi
  cp -r "${new_project_path}" ${apprun_path}
fi
# --------------------------------------------------------------------------
# 开始更新管理平台
sudo systemctl daemon-reload
sudo systemctl enable ${app_name}
sudo systemctl restart ${app_name}
echo "finish!............"
echo "查看运行状态"
sudo systemctl status ${app_name}
mv "${new_project_path}" /tmp/${app_name}_$(date "+%Y-%m-%d_%H:%M:%S")
tail -F /apprun/log/${app_name}/${app_name}.log

