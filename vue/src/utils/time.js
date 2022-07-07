export function formatTime(time) {
  const d = new Date(time)
  const now = Date.now()

  const diff = (now - d) / 1000

  if (diff < 30) {
    return '刚刚'
  } else if (diff < 3600) { // less 1 hour
    return Math.ceil(diff / 60) + '分钟前'
  } else if (diff < 3600 * 24) {
    return Math.ceil(diff / 3600) + '小时前'
  } else if (diff < 3600 * 24 * 2) {
    return '1天前'
  }

  return time
}


export function time_wrap(time) {
  if (time==undefined)
    return "";
  let part1=time.match(/\d+-\d+-\d+/)[0];
  let part2_raw=time.match(/T\d+/)[0].match(/\d+/)[0];
  let part2=parseInt(part2_raw)+8;
  let part3=time.match(/:\d+:\d+/)[0];
  return part1+" "+part2+part3
}
