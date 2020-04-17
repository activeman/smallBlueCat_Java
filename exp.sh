#!/usr/bin/expect
#配合push.sh使用的脚本
set timeout 3600
set src_file [lindex $argv 0]
set pathx [lindex $argv 1]
set password [lindex $argv 2]
spawn scp $src_file $pathx
#spawn scp -P $port -r $username@$host:$src_file $dest_file
expect {
 "(yes/no)?" {
   send "yes\n"
   expect "*assword:" { send "$password\n"}
  }
  "*assword:" {
   send "$password\n"
 }
}
expect "100%"
expect eof
